package za.ac.cput.service.location.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.Country;
import za.ac.cput.service.location.ICountryService;

import java.util.List;
import java.util.Optional;


@Service
public class CountryService implements ICountryService {
    @Override
    public Country save(Country country) {
        return null;
    }

    @Override
    public Optional<Country> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(Country country) {

    }

    @Override
    public List<Country> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
