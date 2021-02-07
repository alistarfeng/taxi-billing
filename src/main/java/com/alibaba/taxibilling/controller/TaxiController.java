package com.alibaba.taxibilling.controller;

import com.alibaba.taxibilling.bean.TaxiInfo;
import com.alibaba.taxibilling.common.CommonResult;
import com.alibaba.taxibilling.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Controller
@RequestMapping("/taxi")
@Validated
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @RequestMapping(value = "/getTaxiInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getTaxiInfo(@PathVariable("id") @Min(1) Integer id){
        TaxiInfo taxi = taxiService.getTaxiInfo(id);
        return CommonResult.success(taxi);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody @Validated TaxiInfo taxi){
        return  taxiService.add(taxi);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") @Min(1) Integer id){
        return  taxiService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody @Validated TaxiInfo taxi){
        return  taxiService.update(taxi);
    }

}
