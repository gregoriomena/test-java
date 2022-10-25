package com.test.java.models.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.java.models.Price;

public interface PriceDao extends CrudRepository<Price, Long> {

	@Query("select p from Price p where p.startDate <= :referenceDate and p.endDate >= :referenceDate and p.brandId = :brandId and p.productId = :productId order by priority desc")
	List<Price> findApplicablePrices(Date referenceDate, Long brandId, Long productId);
}
