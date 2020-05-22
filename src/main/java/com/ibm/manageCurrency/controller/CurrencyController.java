package com.ibm.manageCurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.manageCurrency.entity.Conversion;
import com.ibm.manageCurrency.model.ConversionRequest;
import com.ibm.manageCurrency.repository.ConversionJPARepository;

@RestController
@RequestMapping("/conversionFactor")
public class CurrencyController {
	
	@Autowired
	private ConversionJPARepository repo;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addConversionFactor(@RequestBody ConversionRequest currency) {
		System.out.println("currency - > " + currency.toString());
		repo.save(new Conversion(currency.getCountryCode(), currency.getConversionFactor()));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{countryCode}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Double> getConversionFactor(@PathVariable String countryCode) {
		System.out.println("currency - > " + countryCode);
		Conversion factor = repo.getConversionFactorByCountryCode(countryCode);
		return new ResponseEntity<>(factor.getConversionFactor(), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT) 
	public ResponseEntity<?> updateConversionFactor(@RequestBody ConversionRequest conversionRequest) {
		System.out.println("conversionRequest - > " + conversionRequest.toString());
		repo.updateConversionFactor(conversionRequest.getConversionFactor(), conversionRequest.getCountryCode());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	 

}
