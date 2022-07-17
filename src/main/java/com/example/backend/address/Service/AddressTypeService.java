package com.example.backend.address.Service;

import com.example.backend.address.model.Address_Type;

import java.util.Collection;

public interface AddressTypeService {
    Address_Type create(Address_Type addressType);
    Address_Type get(long id);
    Collection<Address_Type> list(int limit);
}
