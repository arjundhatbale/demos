package com.main.OneToManyMapping.controller;

import com.main.OneToManyMapping.entity.Customer;
import com.main.OneToManyMapping.repository.CustomerRepository;
import com.main.OneToManyMapping.repository.ProductRepository;
import com.main.OneToManyMapping.service.OrderResponse;
import com.main.OneToManyMapping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/saveCustomer")
    public Customer saveCustomer(@RequestBody ProductService productService){
        return  customerRepository.save(productService.getCustomer());
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
}
