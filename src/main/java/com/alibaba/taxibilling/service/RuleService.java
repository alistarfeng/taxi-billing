package com.alibaba.taxibilling.service;

import com.alibaba.taxibilling.bean.RuleInfo;
import com.alibaba.taxibilling.common.CommonResult;
import com.alibaba.taxibilling.util.TimeOperateUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public interface RuleService {

    public List<RuleInfo> getRuleInfoByTaxiTypeAndTime(String taxiType, String time);

    public RuleInfo getRuleInfo(Integer id);

    public CommonResult add(RuleInfo rule);

    public CommonResult delete(Integer id);

    public CommonResult update(RuleInfo rule);

}
