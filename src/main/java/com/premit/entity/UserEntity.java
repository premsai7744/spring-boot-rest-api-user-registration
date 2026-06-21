package com.premit.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usr_dtls")
public class UserEntity {

	@SequenceGenerator(name = "user_id_gen",
			           sequenceName = "usr_dtls_seq",
			           allocationSize = 1) 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
	@Column(name="user_id")
	private int userId; 
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="contact")
	private long contact;
	
	@JoinColumn(name="user_id")
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private List<AddressEntity> listOfAddressEntities;
	
}
