package com.main.OneToManyMapping.service;

import com.main.OneToManyMapping.entity.Customer;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductService {

    private Customer customer;
}
