package com.test.java.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
public class Price implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceList;

	private Long brandId;
	private Date startDate;
	private Date endDate;
	private Long productId;
	private Integer priority;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "currency_id", nullable = false)
	private Currency curr;

	@Column(name = "price")
	private Float priceValue;

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

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Currency getCurr() {
		return curr;
	}

	public void setCurr(Currency curr) {
		this.curr = curr;
	}

}
