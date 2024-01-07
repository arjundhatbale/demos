package com.multitable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multitable.entity.Shop;
import com.multitable.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	public ShopController(ShopService shopService) {
		this.shopService =shopService;
	}
	
	@GetMapping("/getShop")
	public List<Shop> getAllShop(){
		return shopService.getAllShop();
	}
	
//	@PostMapping("/saveshop")
//	public Shop addShop( Shop shop) {
//		return shopService.addShop(shop);
//	}
	
	@PostMapping("/saveshop")
	public ResponseEntity<Shop> addShop(Shop shop){
		Shop addShop = shopService.addShop(shop);
		return new ResponseEntity<>(addShop,HttpStatus.CREATED);
				 
	}
	
}
