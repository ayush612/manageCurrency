package com.ibm.manageCurrency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.manageCurrency.entity.Conversion;

@Component
@Transactional
public interface ConversionJPARepository extends JpaRepository<Conversion, Integer> {

	Conversion getConversionFactorByCountryCode(String countryCode);
	
	@Modifying(clearAutomatically = true)
	@Query("update conversion c set c.conversionFactor = :conversionFactor WHERE c.countryCode = :countryCode")
	void updateConversionFactor(Double conversionFactor, String countryCode);

}
