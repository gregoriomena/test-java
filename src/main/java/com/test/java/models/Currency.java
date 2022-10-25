package com.test.java.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
public class Currency implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long currencyId;

	private String curr;

	public Long getCurrencyId() {
		return currencyId;
	}

	public String getCurr() {
		return curr;
	}

}
