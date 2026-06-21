package com.premit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premit.dao.repository.UserRepository;
import com.premit.dto.UserDto;
import com.premit.entity.AddressEntity;
import com.premit.entity.UserEntity;

@Service
public class UserServiceImplClass implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public String userRegistration(UserDto userDto) {
	
		List<AddressEntity> listOfAddressEntity = new ArrayList<>();
		
		UserEntity userEntity = new UserEntity();
		userEntity.setContact(userDto.getContact());
		userEntity.setDateOfBirth(userDto.getDateOfBirth());
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setGender(userDto.getGender());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setPassword(userDto.getPassword());
		userEntity.setUserName(userDto.getUserName());
		
		userDto.getListOfAddressEntities().forEach(e->{
			AddressEntity addressEntity = new AddressEntity();
			addressEntity.setCity(e.getCity());
			addressEntity.setDistrict(e.getDistrict());
			addressEntity.setHouseNo(e.getHouseNo());
			addressEntity.setLandMark(e.getLandMark());
			addressEntity.setPinCode(e.getPinCode());
			addressEntity.setState(e.getState());
			addressEntity.setStreet(e.getStreet());
			listOfAddressEntity.add(addressEntity);
		});
		
		userEntity.setListOfAddressEntities(listOfAddressEntity);
		
		System.out.println("UserServiceImplClass.userRegistration()::Dto to entity converstion::UserEntity:"+userEntity);
		
		if(userRepository.findByUserName(userEntity.getUserName()).isPresent()) {
			return "User already existed with username : "+userEntity.getUserName()+", Please try with new username.";
		} else {
			UserEntity savedEntity = userRepository.save(userEntity);
			if(savedEntity!=null) {
				return "user registered successfully, Welcome user : "+savedEntity.getFirstName();
			} else {
				return "Unable to register user, Please try again.";
			}
		}
	}
}
