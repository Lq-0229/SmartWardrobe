package com.lq.SmartWardrobe.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lq.SmartWardrobe.entity.Donation;
import com.lq.SmartWardrobe.result.Result;
import com.lq.SmartWardrobe.service.DonationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
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
@RestController
@Api(tags = "捐赠信息")
@RequestMapping("/SmartWardrobe/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;


    //    新增捐赠信息
    @ApiOperation("新增捐赠信息")
    @PostMapping("/save")
    public Result saveDonation(@Valid @RequestBody Donation donation){
        donationService.save(donation);
        return Result.ok();
    }



    //根据id删除捐赠信息
    @ApiOperation("根据id删除捐赠信息")
    @DeleteMapping("/delete/{d_id}")
    public Result deleteById(@PathVariable("d_id") Long id){
        boolean b = donationService.removeById(id);
        if (b) {
            return Result.ok();
        }else {
            return Result.fail();
        }

    }

    //根据name删除捐赠信息
    @ApiOperation("根据name删除捐赠信息")
    @DeleteMapping("/remove/{name}")
    public Result removeDonationByName(@PathVariable("name") String name){
        //先根据name查询
        LambdaQueryWrapper<Donation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Donation::getName,name);
        donationService.remove(wrapper);
        return Result.ok();
    }


    //根据id修改捐赠信息
    @ApiOperation("修改捐赠信息")
    @PutMapping("/update")
    public Result updateDonation(@RequestBody Donation donation){
        donationService.updateById(donation);
        return Result.ok();
    }

    //根据id获取评价
    @ApiOperation("根据id获取捐赠信息")
    @GetMapping("/get/{id}")
    public Result getDonation(@PathVariable("id") Integer id){
        Donation donation = donationService.getById(id);
        return Result.ok(donation);
    }

    //获取所有捐赠信息
    @ApiOperation("获取所有捐赠信息")
    @GetMapping("/getAll")
    public Result getAllAppraise(){
        List<Donation> appraiseList = donationService.list();
        return Result.ok(appraiseList);
    }



}

