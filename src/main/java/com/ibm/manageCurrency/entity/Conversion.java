package com.ibm.manageCurrency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="conversion")
public class Conversion {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name = "countryCode")
	private String countryCode;
	@Column(name = "conversionFactor")
	private Double conversionFactor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	
	public Conversion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conversion(String countryCode, double conversionFactor) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}
	
	
}
