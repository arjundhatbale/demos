package com.multitable.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ShopNo")
	private Long ShopNo;
	
	@Column(name="ShopName")
	private String ShopName;
	
	@Column(name="ShopKeeperName")
	private String ShopKeeperName;
	
	@Column(name="Address")
	private String Address;

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(Long shopNo, String shopName, String shopKeeperName, String address) {
		super();
		ShopNo = shopNo;
		ShopName = shopName;
		ShopKeeperName = shopKeeperName;
		Address = address;
	}

	public Long getShopNo() {
		return ShopNo;
	}

	public void setShopNo(Long shopNo) {
		ShopNo = shopNo;
	}

	public String getShopName() {
		return ShopName;
	}

	public void setShopName(String shopName) {
		ShopName = shopName;
	}

	public String getShopKeeperName() {
		return ShopKeeperName;
	}

	public void setShopKeeperName(String shopKeeperName) {
		ShopKeeperName = shopKeeperName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Shop [ShopNo=" + ShopNo + ", ShopName=" + ShopName + ", ShopKeeperName=" + ShopKeeperName + ", Address="
				+ Address + "]";
	}
	
	 
	
}
