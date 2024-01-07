package com.multitable.pojo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name="employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private Long empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_age")
	private Integer empAge;
	
	@Column(name ="date_time")
	private LocalDateTime date_time;
	 
//	// foreign key column  : address_add_id
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="fk_add_id")
	

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="fk_add_id", referencedColumnName = "emp_id")
//	private List<Address> address;
	
	
	 
	 
	
}
