package com.test.java.models.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.test.java.models.Price;

@DataJpaTest
class PriceDaoTest {

	@Autowired
	private PriceDao priceDao;

	/**
	 * - Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * - Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 *
	 */
	@Test
	void testUniquePrice() throws ParseException {

		testUniquePrice("2020-06-14 10.00.00", Float.valueOf("35.50"));
		testUniquePrice("2020-06-14 21.00.00", Float.valueOf("35.50"));
	}


	/**
	 * - Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * - Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 * - Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void testTwoValidPricesInCorrectOrder() throws ParseException {

		testTwoValidPricesInCorrectOrder("2020-06-14 16.00.00");
		testTwoValidPricesInCorrectOrder("2020-06-15 10.00.00");
		testTwoValidPricesInCorrectOrder("2020-06-16 21.00.00");
	}

	private void testUniquePrice(String date, Float expectedValue) throws ParseException {
		List<Price> prices = priceDao.findApplicablePrices(toDate(date), 1L, 35455L);

		assertFalse(prices.isEmpty());
		assertEquals(1, prices.size());
		assertEquals(expectedValue, prices.get(0).getPriceValue());
	}

	private void testTwoValidPricesInCorrectOrder(String date) throws ParseException {
		List<Price> prices = priceDao.findApplicablePrices(toDate(date), 1L, 35455L);

		assertFalse(prices.isEmpty());
		assertEquals(Integer.valueOf(2), prices.size());
		assertTrue(prices.get(0).getPriority() > prices.get(1).getPriority());
	}

	private Date toDate(String source) throws ParseException {
		Date referenceDate =  new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").parse(source);
		return referenceDate;
	}
}
