package com.example.backend.address.repo;

import com.example.backend.address.model.Address_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface Address_TypeRepo extends JpaRepository <Address_Type,Long>{



}
