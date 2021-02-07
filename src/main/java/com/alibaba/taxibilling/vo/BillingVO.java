package com.alibaba.taxibilling.vo;

import java.io.Serializable;

public class BillingVO implements Serializable {

    /**
     * 车辆id
     */
    private Integer taxiId;
    /**
     * 车辆类型
     */
    private String taxiType;
    /**
     * 上车时间
     */
    private String beginTime;
    /**
     * 行驶的总距离
     */
    private Double distance;
    /**
     * 车费
     */
    private Double price;

    public Integer getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Integer taxiId) {
        this.taxiId = taxiId;
    }

    public String getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(String taxiType) {
        this.taxiType = taxiType;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
