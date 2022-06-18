package za.ac.cput.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.location.Country;

@Repository
public interface ICountryRepository extends JpaRepository<Country, String> {
}
