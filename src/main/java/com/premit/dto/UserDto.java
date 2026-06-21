package com.premit.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class UserDto {
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate dateOfBirth;
	
	private String gender;
	
	private long contact;
	
	private List<AddressDto> listOfAddressEntities;
	
}
