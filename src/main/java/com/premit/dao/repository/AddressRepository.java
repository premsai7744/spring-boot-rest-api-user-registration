package com.premit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.premit.entity.AddressEntity;
import com.premit.entity.UserEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{

}
