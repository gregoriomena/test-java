package com.test.java.models.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.test.java.dto.PriceDTO;
import com.test.java.models.Currency;
import com.test.java.models.Price;
import com.test.java.models.dao.PriceDao;

class PriceServiceImplTest {

	@Mock
	private PriceDao priceDao;

	@InjectMocks
	private PriceServiceImpl priceService;

	@BeforeEach
	public void setupMock() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void chooseCorrectOrder() {

		List<Price> prices = new ArrayList<>();

		addPriceWithPriority(prices, 10);
		addPriceWithPriority(prices, 5);

		when(priceDao.findApplicablePrices(any(Date.class), anyLong(), anyLong())).thenReturn(prices);

		PriceDTO price = priceService.findPrice(new Date(), 1L, 2L);

		assertEquals(10, price.getPriority());
	}

	@Test
	void checkIfExistsWhenEmpty() {

		checkIfExists(new ArrayList<>());
	}

	@Test
	void checkIfExistsWhenNull() {

		checkIfExists(null);
	}

	private void checkIfExists(List<Price> prices) {
		when(priceDao.findApplicablePrices(any(Date.class), anyLong(), anyLong())).thenReturn(prices);

		PriceDTO price = priceService.findPrice(new Date(), 1L, 2L);

		assertNull(price);
	}

	private void addPriceWithPriority(List<Price> prices, int priority) {
		Price price = new Price();
		price.setPriority(priority);
		price.setCurr(new Currency());
		prices.add(price);
	}
}
