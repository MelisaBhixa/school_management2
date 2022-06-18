/**
 IStudentAddressRepository.java
 Entity for IStudentAddressRepository
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */


package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.StudentAddress;

@Repository
public interface IStudentAddressRepository extends JpaRepository<StudentAddress, String> {
}
