package com.example.backend.address.Service;

import com.example.backend.address.model.Address;

public interface AddressService {
    Address  create(Address address);
    Address get(long id);

}
