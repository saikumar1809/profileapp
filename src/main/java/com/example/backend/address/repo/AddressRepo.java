package com.example.backend.address.repo;

import com.example.backend.address.model.Address;

import com.example.backend.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface AddressRepo extends JpaRepository<Address,Long> {

  Address findByUserId(long id);


}
