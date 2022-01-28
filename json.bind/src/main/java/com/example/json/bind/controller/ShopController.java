package com.example.json.bind.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.json.bind.entity.Shop;
import com.example.json.bind.entity.ShopGetResponse;
import com.example.json.bind.entity.ShopResponse;
import com.example.json.bind.repo.ShopRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("shops")
public class ShopController {

	@Autowired 
	ShopRepository shopRepository;
	@GetMapping
	public List<ShopGetResponse> getAllShops(){
		
		List<Shop> shops = (List<Shop>) shopRepository.findAll();
		
		List<ShopGetResponse> returned = new ArrayList<>();
		
		for(Shop temp : shops) {
			ObjectMapper om = new ObjectMapper();
			om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			JsonNode jn = temp.getMenu();
			ShopGetResponse response = new ShopGetResponse(temp.getName(),
					temp.getOwner(),temp.getId(),jn);
			returned.add(response);

		}
		
		return returned;
		
	}
	
	@PostMapping
	public ShopResponse createShop(@RequestBody Shop shop) {
		ShopResponse returned = new ShopResponse();
		Shop shop1 =  shopRepository.save(shop);
		BeanUtils.copyProperties(shop, returned);

		return returned;
		
	}
}
