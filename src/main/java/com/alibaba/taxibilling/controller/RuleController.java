package com.alibaba.taxibilling.controller;

import com.alibaba.taxibilling.bean.RuleInfo;
import com.alibaba.taxibilling.bean.TaxiInfo;
import com.alibaba.taxibilling.common.CommonResult;
import com.alibaba.taxibilling.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Controller
@RequestMapping("/rule")
@Validated
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping(value = "/getRuleInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getRuleInfo(@PathVariable("id") @Min(1) Integer id){
        RuleInfo ruleInfo = ruleService.getRuleInfo(id);
        return CommonResult.success(ruleInfo);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody @Validated RuleInfo rule){
        return  ruleService.add(rule);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") @Min(1) Integer id){
        return  ruleService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody @Validated RuleInfo rule){
        return  ruleService.update(rule);
    }

}
