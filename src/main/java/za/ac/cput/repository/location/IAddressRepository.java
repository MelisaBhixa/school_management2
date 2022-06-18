/*
IAddressRepository.java
Author: Melisa Bhixa
Date: 15 June 2022
 */

package za.ac.cput.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.location.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, String> {
}
