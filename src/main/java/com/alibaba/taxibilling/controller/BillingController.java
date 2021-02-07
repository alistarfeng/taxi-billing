package com.alibaba.taxibilling.controller;


import com.alibaba.taxibilling.bean.ChargingInfo;
import com.alibaba.taxibilling.common.CommonResult;
import com.alibaba.taxibilling.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Controller
@RequestMapping("/billing")
@Validated
public class BillingController {
    @Autowired
    private BillingService billingService;

    @RequestMapping(value = "/generateBilling", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateBilling(@RequestParam @Min(1)  Integer taxiId, @RequestBody @Validated ChargingInfo charging) {
        return billingService.generateBilling(taxiId, charging);
    }
}
