package com.premit.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usr_address")
public class AddressEntity {

	
	@SequenceGenerator(name="addr_id_gen",
			           sequenceName = "usr_address_seq",
			           allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addr_id_gen")
	@Column(name="addr_id")
	private int addressId; 
	
	@Column(name="house_no")
	private String houseNo;
	
	@Column(name="street")
	private String street;
	
	@Column(name="land_mark")
	private String landMark;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pincode")
	private int pinCode; 
	
	@Column(name="district")
	private String district;
	
	@Column(name="state")
	private String state; 
	
}
