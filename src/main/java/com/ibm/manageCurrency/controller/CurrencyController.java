package com.ibm.manageCurrency.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.manageCurrency.entity.Conversion;
import com.ibm.manageCurrency.model.APIResponse;
import com.ibm.manageCurrency.model.ConversionFactorResponse;
import com.ibm.manageCurrency.model.ConversionRequest;
import com.ibm.manageCurrency.service.ManageCurrencyService;

@RestController
@RequestMapping("/conversionFactor")
public class CurrencyController {
	private static Logger log = LoggerFactory.getLogger(CurrencyController.class);

	@Autowired
	private ManageCurrencyService manageCurrencyService;
	
	@Autowired
	Environment environment;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<APIResponse> addConversionFactor(@RequestBody ConversionRequest request) {
		APIResponse response = new APIResponse();
		log.info("ConversionRequest - > " + request.toString());
		Conversion conversion = manageCurrencyService.addConversionFactor(request);
		if(Objects.nonNull(conversion)) {
			response.setStatus(APIResponse.STATUS_SUCCESS);
		} else {
			response.setStatus(APIResponse.STATUS_ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(path = "/{countryCode}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ConversionFactorResponse> getConversionFactor(@PathVariable String countryCode) {
		log.info("currency - > " + countryCode);
		String serverPort = environment.getProperty("local.server.port");
		 
        System.out.println("Port : " + serverPort);
		ConversionFactorResponse factorResponse = manageCurrencyService.getConversionFactor(countryCode);
		/*
		 * if(Objects.nonNull(factorResponse)){ return new
		 * ResponseEntity<>(factorResponse, HttpStatus.OK); }
		 */
		return new ResponseEntity<>(factorResponse, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT) 
	public ResponseEntity<APIResponse> updateConversionFactor(@RequestBody ConversionRequest request) {
		APIResponse response = new APIResponse();
		log.info("conversionRequest - > " + request.toString());
		int updateCount = manageCurrencyService.updateConversionFactor(request);
		if(updateCount > 0) {
			response.setStatus(APIResponse.STATUS_SUCCESS);
		} else {
			response.setStatus(APIResponse.STATUS_ERROR);
		}
		return ResponseEntity.ok(response);
	}
	 

}
