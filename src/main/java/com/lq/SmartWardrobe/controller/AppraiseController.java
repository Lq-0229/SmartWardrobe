package com.lq.SmartWardrobe.controller;


import com.lq.SmartWardrobe.entity.Appraise;
import com.lq.SmartWardrobe.result.Result;
import com.lq.SmartWardrobe.service.AppraiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lq
 * @since 2023-06-01
 */
@Api(tags = "评价测试")
@RestController
@RequestMapping("/SmartWardrobe/appraise")
public class AppraiseController {
    @Autowired
    private AppraiseService appraiseService;

    //    添加评价
    @ApiOperation("添加评价")
    @PostMapping("/save")
    public Result saveAppraise(@Valid @RequestBody Appraise appraise){
        appraiseService.save(appraise);
        return Result.ok();
    }


    //根据id删除评价
    @ApiOperation("根据id删除评论")
    @DeleteMapping("/remove/{id}")
    public Result removeAppraise(@PathVariable("id") Integer id){
        appraiseService.removeById(id);
        return Result.ok();
    }


    //修改评价
    @ApiOperation("修改评论")
    @PutMapping("/update")
    public Result updateAppraise(@RequestBody Appraise appraiseNew){

        appraiseService.updateById(appraiseNew);
        return Result.ok();
    }

    //根据id获取评价
    @ApiOperation("根据id获取评论")
    @GetMapping("/get/{id}")
    public Result getAppraise(@PathVariable("id") Integer id){
        Appraise appraise = appraiseService.getById(id);
        return Result.ok(appraise);
    }

    //获取所有评价
    @ApiOperation("获取所有评价")
    @GetMapping("/getAll")
    public Result getAllAppraise(){
        List<Appraise> appraiseList = appraiseService.list();
        return Result.ok(appraiseList);
    }

}

