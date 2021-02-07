package com.alibaba.taxibilling.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 出租车类
 */
public class TaxiInfo implements Serializable{

	/**
	 * 出租车id
	 */
	@NotNull
	@Min(1)
	private Integer id;

	/**
	 * 出租车类型
	 */
	@NotBlank
	private String taxiType;

	public TaxiInfo() {

	}

	public TaxiInfo(Integer id, String taxiType) {
		this.id = id;
		this.taxiType = taxiType;
	}

	public String getTaxiType() {
		return taxiType;
	}

	public void setTaxiType(String taxiType) {
		this.taxiType = taxiType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
