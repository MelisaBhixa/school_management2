package za.ac.cput.service.location;
/*
 *Country Service class
 *CountryService.java
 * Thina Mbiza: 217217095
 * Date: 18/06/2022
 */
import za.ac.cput.domain.location.Country;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICountryService extends IService<Country, String> {
    List<Country> findAll();
    void deleteById(String id);
}
