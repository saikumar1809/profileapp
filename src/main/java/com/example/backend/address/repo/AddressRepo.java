package com.example.backend.address.repo;

import com.example.backend.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AddressRepo extends JpaRepository<Address,Long> {

    Address findByUser_id(long id);


}
