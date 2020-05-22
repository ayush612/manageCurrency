package com.ibm.manageCurrency.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.manageCurrency.model.APIResponse;
import com.ibm.manageCurrency.model.ConversionFactorResponse;
import com.ibm.manageCurrency.model.ConversionRequest;
import com.ibm.manageCurrency.service.ManageCurrencyService;

@RestController
@RequestMapping("/conversionFactor")
public class CurrencyController {
	
	@Autowired
	private ManageCurrencyService manageCurrencyService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addConversionFactor(@RequestBody ConversionRequest request) {
		System.out.println("ConversionRequest - > " + request.toString());
		manageCurrencyService.addConversionFactor(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{countryCode}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<APIResponse<ConversionFactorResponse>> getConversionFactor(@PathVariable String countryCode) {
		APIResponse<ConversionFactorResponse> response = new APIResponse<>();
		System.out.println("currency - > " + countryCode);
		ConversionFactorResponse factorResponse = manageCurrencyService.getConversionFactor(countryCode);
		if(Objects.nonNull(factorResponse)){
			response.setResponse(factorResponse);
			response.setStatus(APIResponse.STATUS_SUCCESS);
		}
		return ResponseEntity.ok(response);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT) 
	public ResponseEntity<?> updateConversionFactor(@RequestBody ConversionRequest request) {
		System.out.println("conversionRequest - > " + request.toString());
		manageCurrencyService.updateConversionFactor(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	 

}
