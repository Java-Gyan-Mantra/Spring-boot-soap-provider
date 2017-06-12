package com.dugu.spring.boot.soap.api.dto;

public class UserInfo {
	private String name;
	private String bloodGroup;
	private String bikeModel;
	private int age;
	private String dlNo;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String name, String bloodGroup, String bikeModel, int age,
			String dlNo, Address address) {
		super();
		this.name = name;
		this.bloodGroup = bloodGroup;
		this.bikeModel = bikeModel;
		this.age = age;
		this.dlNo = dlNo;
		this.address = address;
	}

}
