package com.example.json.bind.entity;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "shops")
public class Shop {

	private Long id;
	
	private String name;
	
	private String owner;
	
	@Transient
	private JsonNode menu;

	public Shop(Long id, String name, String owner, String menuString) throws JsonMappingException, JsonProcessingException {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		ObjectMapper mapper = new ObjectMapper();
		this.menu = mapper.readValue(menuString , JsonNode.class); //setting string as json node

	}

	public Shop() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// for jackson
	@Transient
	public JsonNode getMenu() {
		return menu;
	}

	public void setMenu(JsonNode menu) {
		this.menu = menu;
	}
	
	//for jpa 
	/*
	 *  jpa will execute getJsonColumn, when reading, 
	 *  jpa will execute setJsonColumn and 
	 *  jsonNode will be translated back and forward to string:
	 */
	//get for reading
	//set for writing
	
	//writing into database
	@Column(name = "shop_menu")
	public String getShopMenu() {
		return this.menu.toString();
	}
	
	public void setShopMenu(String shop_menu) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
			this.menu = mapper.readValue(shop_menu , JsonNode.class);
		
	}
	@Column(name = "owner")
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	 
	
}
