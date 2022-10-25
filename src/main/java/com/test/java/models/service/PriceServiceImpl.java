package com.test.java.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.test.java.dto.PriceDTO;
import com.test.java.models.Price;
import com.test.java.models.dao.PriceDao;

@Service
public class PriceServiceImpl implements IPriceService {

	@Autowired
	private PriceDao priceDao;

	@Override
	public PriceDTO findPrice(Date fechaAplicacion, Long brandId, Long productId) {

		List<Price> prices = priceDao.findApplicablePrices(fechaAplicacion, brandId, productId);
		PriceDTO price = null;

		if (!CollectionUtils.isEmpty(prices)) {
			price = new PriceDTO(prices.get(0));
		}

		return price;
	}

}
