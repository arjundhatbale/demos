package com.multitable.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="add_id")
	private Long addressId;
	private String city;
	private String addressType;
	
	/* This @OneToOne is use only for one ot one mapping 
//	@OneToOne(mappedBy = "address")
//	private Employee employee;
	*/
	
	 

	 
	
}
