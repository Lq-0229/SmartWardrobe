package com.lq.SmartWardrobe.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lq.SmartWardrobe.entity.User;
import com.lq.SmartWardrobe.exception.lqException;
import com.lq.SmartWardrobe.result.Result;
import com.lq.SmartWardrobe.service.UserService;
import com.lq.SmartWardrobe.utils.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lq
 * @since 2023-05-22
 */
@Api(tags = "用户测试接口")
@RestController
@RequestMapping("/SmartWardrobe/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation("登录测试")
    @PostMapping ("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        //1. 获取输入用户名和密码
        String username = user.getUsername();

        //2 根据用户名查询数据库
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.eq(User::getUsername,username);
        User userOne = userService.getOne(wrapper);

        //3. 用户信息是否存在
        if (userOne == null) {
            throw new lqException(201,"用户不存在");
        }
        //4 判断密码
        //数据库存密码（MD5）
        String passwordDb = userOne.getPassword();

        //获取输入的密码
        String passwordInput = MD5.encrypt(user.getPassword());

        if (!passwordDb.equals(passwordInput)){
            throw new lqException(201,"密码错误");
        }
        //登录信息存入session
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",passwordDb);

        return Result.ok();
    }

    @ApiOperation(value = "注册测试")
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        //1. 获取输入用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();
        String passwordTwo = user.getRepassword();


        //2 根据用户名查询数据库
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.eq(User::getUsername,username);
        User userOne = userService.getOne(wrapper);

        //3. 用户信息是否存在
        if (userOne != null) {
            throw new lqException(201,"用户已经存在，请重新输入");
        }
        //判断两次密码是否正确
        if (!password.equals(passwordTwo)){
            throw new lqException(201,"两次密码不同，请重新输入");
        }

        String email = user.getEmail();
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (!email.matches(regex)){
            throw new lqException(201,"邮箱格式不正确");
        }

        User userEntity = new User();
        userEntity.setEmail(email);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setRepassword(passwordTwo);

        userService.save(userEntity);

        return Result.ok();
    }



    //登出
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request){
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("password");
        return Result.ok();
    }

}

