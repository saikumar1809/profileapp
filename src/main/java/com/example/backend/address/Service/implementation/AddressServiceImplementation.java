package com.example.backend.address.Service.implementation;

import com.example.backend.address.Service.AddressService;
import com.example.backend.address.model.Address;
import com.example.backend.address.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AddressServiceImplementation  implements AddressService {
    private final AddressRepo addressRepo;

    @Override
    public Address create(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address get(long id) {
        return addressRepo.findByUserId(id);
    }


}
