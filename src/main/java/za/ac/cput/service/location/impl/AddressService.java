package za.ac.cput.service.location.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.Address;
import za.ac.cput.service.location.IAddressService;

import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public Optional<Address> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(Address address) {

    }
}
