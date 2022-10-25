package com.test.java.dto;

import java.util.Date;

import com.test.java.models.Price;

public class PriceDTO {

	private Long priceList;
	private Long brandId;
	private Date startDate;
	private Date endDate;
	private Long productId;
	private Integer priority;
	private Float priceValue;
	private String curr;



	public PriceDTO(Price price) {

		this.priceList = price.getPriceList();
		this.brandId = price.getBrandId();
		this.startDate = price.getStartDate();
		this.endDate = price.getEndDate();
		this.productId = price.getProductId();
		this.priority = price.getPriority();
		this.priceValue = price.getPriceValue();
		this.curr = price.getCurr().getCurr();
	}

	public Long getPriceList() {
		return priceList;
	}
	public Long getBrandId() {
		return brandId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Long getProductId() {
		return productId;
	}
	public Integer getPriority() {
		return priority;
	}
	public Float getPriceValue() {
		return priceValue;
	}
	public String getCurr() {
		return curr;
	}
}
