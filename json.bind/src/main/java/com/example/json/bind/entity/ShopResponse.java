package com.example.json.bind.entity;

public class ShopResponse {

	private String name;
	
	private String owner;
	
	private Long id;
	
	private String shopMenu;
	
	public ShopResponse() {};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopMenu() {
		return shopMenu;
	}

	public void setShopMenu(String shopMenu) {
		this.shopMenu = shopMenu;
	}
}
