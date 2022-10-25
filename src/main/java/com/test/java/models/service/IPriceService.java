package com.test.java.models.service;

import java.util.Date;

import com.test.java.dto.PriceDTO;

public interface IPriceService {

	PriceDTO findPrice(Date fechaAplicacion, Long brandId, Long productId);
}
