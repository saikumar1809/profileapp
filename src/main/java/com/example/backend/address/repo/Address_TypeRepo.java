package com.example.backend.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Address_TypeRepo extends JpaRepository <Address_TypeRepo,Long>{



}
