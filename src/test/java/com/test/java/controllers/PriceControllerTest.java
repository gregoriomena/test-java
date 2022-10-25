package com.test.java.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import com.test.java.dto.PriceDTO;
import com.test.java.models.service.IPriceService;

class PriceControllerTest {

	@Mock
	private IPriceService priceService;

	@InjectMocks
	private PriceController priceController;

	@BeforeEach
	public void setupMock() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testPriceExists() {

		when(priceService.findPrice(any(Date.class), anyLong(), anyLong()))
				.thenReturn(mock(PriceDTO.class));

		PriceDTO price = findAnyPrice();
		assertNotNull(price);

	}

	@Test
	void testPriceNotExists() {

		when(priceService.findPrice(any(Date.class), anyLong(), anyLong()))
				.thenReturn(null);

		ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> {
			findAnyPrice();
		}, "ResponseStatusException was expected");

		Assertions.assertEquals("404 NOT_FOUND \"Price not found\"", thrown.getMessage());
	}

	private PriceDTO findAnyPrice() {
		return priceController.findPrice(new Date(), 1L, 2L);
	}
}
