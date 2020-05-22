package com.ibm.manageCurrency.model;

public class ConversionRequest {

	private String countryCode;
	private Double conversionFactor;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	@Override
	public String toString() {
		return "ConversionRequest [countryCode=" + countryCode + ", conversionFactor=" + conversionFactor + "]";
	}

	
}
