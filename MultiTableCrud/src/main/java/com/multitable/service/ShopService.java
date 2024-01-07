package com.multitable.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.multitable.entity.Shop;
import com.multitable.repository.ShopRepository;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	public ShopService(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}
	
	
	public List<Shop> getAllShop() {
		return shopRepository.findAll();
	}

	// add shop
	
	public Shop addShop(@RequestBody Shop shop) {
		return shopRepository.save(shop);
		
	}
}
