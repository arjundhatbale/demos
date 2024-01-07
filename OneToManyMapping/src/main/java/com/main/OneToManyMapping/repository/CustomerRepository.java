package com.main.OneToManyMapping.repository;

import com.main.OneToManyMapping.entity.Customer;
import com.main.OneToManyMapping.service.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("select new com.main.OneToManyMapping.service.OrderResponse (c.name, p.productName) from Customer c join c.products p")
    public List<OrderResponse> getJoinInformation();

}
