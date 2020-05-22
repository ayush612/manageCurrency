package com.ibm.manageCurrency.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.manageCurrency.entity.Conversion;
import com.ibm.manageCurrency.model.ConversionFactorResponse;
import com.ibm.manageCurrency.model.ConversionRequest;
import com.ibm.manageCurrency.repository.ConversionJPARepository;

@Component
public class ManageCurrencyService {

	@Autowired
	private ConversionJPARepository repo;
	
	public void addConversionFactor(ConversionRequest request) {
		repo.save(new Conversion(request.getCountryCode(), request.getConversionFactor()));
	}
	
	public ConversionFactorResponse getConversionFactor(String countryCode) {
		ConversionFactorResponse conversionFactorResponse = null;
		Conversion factor = repo.getConversionFactorByCountryCode(countryCode);
		if(Objects.nonNull(factor)){
			conversionFactorResponse = new ConversionFactorResponse(factor.getConversionFactor());
		}
		return conversionFactorResponse;
	}
	
	public void updateConversionFactor(ConversionRequest request) {
		repo.updateConversionFactor(request.getConversionFactor(), request.getCountryCode());
	}
}
