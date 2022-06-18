/*
AddressService.java
Author: Melisa Bhixa
Date: 15 June 2022
 */

package za.ac.cput.service.location.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.Address;
import za.ac.cput.service.location.IAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    private AddressService addressRepository;

    @Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public Optional<Address> read(String s) {
        return this.addressRepository.findById(s);
    }

    


    @Override
    public void delete(Address address) {
        this.addressRepository.delete(address);
    }

    @Override
    public Optional<Address> findById(String s) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    public List<Address> getAll(String staffId) {
        return null;
    }
}
