package za.ac.cput.repository.userInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.userInfo.Name;

@Repository
public interface INameRepository extends JpaRepository<Name, String> {
}
