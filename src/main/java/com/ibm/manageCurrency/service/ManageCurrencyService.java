package com.ibm.manageCurrency.service;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;
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

	public Conversion addConversionFactor(ConversionRequest request) {
		Conversion conversion = null;
		if (Objects.nonNull(request) && StringUtils.isNotBlank(request.getCountryCode())) {
			conversion = repo.save(new Conversion(request.getCountryCode(), request.getConversionFactor()));
		}
		return conversion;
	}

	public ConversionFactorResponse getConversionFactor(String countryCode) {
		ConversionFactorResponse conversionFactorResponse = null;
		if (StringUtils.isNotBlank(countryCode)) {
			Conversion factor = repo.getConversionFactorByCountryCode(countryCode);
			if (Objects.nonNull(factor)) {
				conversionFactorResponse = new ConversionFactorResponse(factor.getConversionFactor());
			}
		}
		return conversionFactorResponse;
	}

	public int updateConversionFactor(ConversionRequest request) {
		int count = 0;
		if(StringUtils.isNotBlank(request.getCountryCode())) {
			count = repo.updateConversionFactor(request.getConversionFactor(), request.getCountryCode());
		}
		return count;
	}
}
