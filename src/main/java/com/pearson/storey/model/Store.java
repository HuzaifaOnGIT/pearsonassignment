package com.pearson.storey.model;

import java.util.Date;

public class Store{
	private String storeId;
	private String postCode;
	private String city;
	private String address;
	private Date openedDate;
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}
	public Store() {
		super();
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}
	public Store(String storeId, String postCode, String city, String address, Date openedDate) {
		this.storeId = storeId;
		this.postCode = postCode;
		this.city = city;
		this.address = address;
		this.openedDate = openedDate;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", postCode=" + postCode + ", city=" + city + ", address=" + address
				+ ", openedDate=" + openedDate + "]";
	}
	
	
	

}
