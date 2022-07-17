package com.example.backend.address.Service.implementation;

import com.example.backend.address.Service.AddressTypeService;
import com.example.backend.address.model.Address_Type;
import com.example.backend.address.repo.Address_TypeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AddressTypeServiceImplementation  implements AddressTypeService {
    private final Address_TypeRepo address_typeRepo;
    @Override
    public Address_Type create(Address_Type addressType) {
        return address_typeRepo.save(addressType);
    }

    @Override
    public Address_Type get(long id) {
        return address_typeRepo.findById(id).get();
    }
    @Override
    public Collection<Address_Type> list(int limit) {
        log.info("Fetching all users");
        return address_typeRepo.findAll(PageRequest.of(0,limit)).toList();
    }
}
