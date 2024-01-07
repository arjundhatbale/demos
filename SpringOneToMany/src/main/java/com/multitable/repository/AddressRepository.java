package com.multitable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multitable.pojo.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
