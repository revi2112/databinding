package com.example.json.bind.entity;

import com.fasterxml.jackson.databind.JsonNode;

public class ShopGetResponse {

	private String name;
	
	private String owner;
	
	private Long id;
	
	private JsonNode shopMenu;

	public ShopGetResponse(String name, String owner, Long id, JsonNode shopMenu) {
		super();
		this.name = name;
		this.owner = owner;
		this.id = id;
		this.shopMenu = shopMenu;
	}

	public ShopGetResponse() {}

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

	public JsonNode getShopMenu() {
		return shopMenu;
	}

	public void setShopMenu(JsonNode shopMenu) {
		this.shopMenu = shopMenu;
	};

	
}
