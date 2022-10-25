package com.test.java.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.test.java.dto.PriceDTO;
import com.test.java.models.service.IPriceService;

@RestController
public class PriceController {

	@Autowired
	private IPriceService priceService;

	@GetMapping("/api/price")
	public PriceDTO findPrice(@RequestParam Date fechaAplicacion, @RequestParam Long brandId,
			@RequestParam Long productId) {

		PriceDTO price = priceService.findPrice(fechaAplicacion, brandId, productId);

		if (price == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price not found");
		}

		return price;
	}
}
