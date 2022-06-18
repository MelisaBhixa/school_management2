package za.ac.cput.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.location.City;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<City, String> {
    List<City> findAllCityByCountryId(String CountryId);
}
