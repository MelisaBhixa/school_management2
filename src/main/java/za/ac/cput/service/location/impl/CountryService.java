package za.ac.cput.service.location.impl;
/*
 *Country Service class
 *CountryService.java
 * Thina Mbiza: 217217095
 * Date: 18/06/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.Country;
import za.ac.cput.repository.location.ICountryRepository;
import za.ac.cput.service.location.ICountryService;

import java.util.List;
import java.util.Optional;


@Service
public class CountryService implements ICountryService {
    private final ICountryRepository repository;
    @Autowired
    public CountryService (ICountryRepository repository){
        this.repository = repository;
    }
    @Override
    public Country save (Country country){
        return this.repository.save(country);
    }
    @Override
    public Optional<Country>read(String id){
        return this.repository.findById(id);
    }
    @Override
    public void delete(Country country){
        this.repository.delete(country);
    }
    @Override
    public List<Country> findAll(){
        return this.repository.findAll();
    }
    public void deleteById(String id){
        Optional <Country> country = read(id);
        if (country.isPresent())delete(country.get());
    }
}
