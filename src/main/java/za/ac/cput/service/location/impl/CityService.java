package za.ac.cput.service.location.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.City;
import za.ac.cput.service.location.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public Optional<City> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(City city) {

    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
