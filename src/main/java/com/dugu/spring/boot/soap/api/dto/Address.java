package com.dugu.spring.boot.soap.api.dto;

public class Address {
	private String street;
	private String city;
	private String dist;
	private String state;
	private long pinCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String dist, String state,
			long pinCode) {
		super();
		this.street = street;
		this.city = city;
		this.dist = dist;
		this.state = state;
		this.pinCode = pinCode;
	}

}
