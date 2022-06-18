/*
 * City Service
 * Author: Panashe Muinzani (218186568)
 * 16 June 2022
 */

package za.ac.cput.service.location.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.City;
import za.ac.cput.repository.location.ICityRepository;
import za.ac.cput.service.location.ICityService;

import java.util.List;
import java.util.Optional;

    @Service
    public class CityService implements ICityService {
        private ICityRepository repository;

        @Autowired
        public CityService(ICityRepository repository) {
            this.repository = repository;
        }

        @Override
        public City save(City city) {
            return this.repository.save(city);
        }

        @Override
        public Optional<City> read(String id) {
            return this.repository.findById(id);
        }

        @Override
        public void delete(City city) {
            this.repository.delete(city);
        }

        @Override
        public List<City> findAll() {
            return this.repository.findAll();
        }

        @Override
        public void deleteById(String id) {
            Optional<City> city = read(id);
            if (city.isPresent())
                delete(city.get());
        }
    }

