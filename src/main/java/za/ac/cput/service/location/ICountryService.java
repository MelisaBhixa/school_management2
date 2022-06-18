package za.ac.cput.service.location;

import za.ac.cput.domain.location.Country;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICountryService extends IService<Country, String> {
    List<Country> findAll();
    void deleteById(String id);
}
