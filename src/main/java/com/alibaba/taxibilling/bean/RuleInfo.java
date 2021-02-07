package com.alibaba.taxibilling.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * 计费规则类
 */

public class RuleInfo implements Serializable {

    @Min(1)
    @NotNull
    private Integer id;
    /**
     * 车辆类型
     */
    @NotBlank
    private String taxiType;
    /**
     * 起步价
     */
    @Min(0)
    @NotNull
    private Double initialPrice;

    /**
     * 起步价距离
     */
    @Min(0)
    @NotNull
    private Integer initialDistance;

    /**
     * 区间价格
     */
    @Min(0)
    @NotNull
    private Double rangePrice;

    /**
     * 区间距离最小值
     */
    @Min(0)
    @NotNull
    private Integer minRangeDistance;

    /**
     * 区间距离最大值
     */
    @Min(0)
    @NotNull
    private Integer maxRangeDistance;

    /**
     * 开始时间
     */
    @NotBlank
    private String beginTime;

    /**
     * 开始时间
     */
    @NotBlank
    private String endTime;


    public RuleInfo() {
    }

    public RuleInfo(@Min(1) @NotNull Integer id, String taxiType, @Min(0) @NotNull Double initialPrice,
                    @Min(0) @NotNull Integer initialDistance, @Min(0) @NotNull Double rangePrice,
                    @Min(0) @NotNull Integer minRangeDistance, @Min(0) @NotNull Integer maxRangeDistance,
                    String beginTime, String endTime) {
        this.id = id;
        this.taxiType = taxiType;
        this.initialPrice = initialPrice;
        this.initialDistance = initialDistance;
        this.rangePrice = rangePrice;
        this.minRangeDistance = minRangeDistance;
        this.maxRangeDistance = maxRangeDistance;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(String taxiType) {
        this.taxiType = taxiType;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Integer getInitialDistance() {
        return initialDistance;
    }

    public void setInitialDistance(Integer initialDistance) {
        this.initialDistance = initialDistance;
    }

    public Double getRangePrice() {
        return rangePrice;
    }

    public void setRangePrice(Double rangePrice) {
        this.rangePrice = rangePrice;
    }

    public Integer getMinRangeDistance() {
        return minRangeDistance;
    }

    public void setMinRangeDistance(Integer minRangeDistance) {
        this.minRangeDistance = minRangeDistance;
    }

    public Integer getMaxRangeDistance() {
        return maxRangeDistance;
    }

    public void setMaxRangeDistance(Integer maxRangeDistance) {
        this.maxRangeDistance = maxRangeDistance;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleInfo ruleInfo = (RuleInfo) o;
        return Objects.equals(id, ruleInfo.id) &&
                Objects.equals(taxiType, ruleInfo.taxiType) &&
                Objects.equals(initialPrice, ruleInfo.initialPrice) &&
                Objects.equals(initialDistance, ruleInfo.initialDistance) &&
                Objects.equals(rangePrice, ruleInfo.rangePrice) &&
                Objects.equals(minRangeDistance, ruleInfo.minRangeDistance) &&
                Objects.equals(maxRangeDistance, ruleInfo.maxRangeDistance) &&
                Objects.equals(beginTime, ruleInfo.beginTime) &&
                Objects.equals(endTime, ruleInfo.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxiType, initialPrice, initialDistance, rangePrice, minRangeDistance,
                maxRangeDistance, beginTime, endTime);
    }
}
