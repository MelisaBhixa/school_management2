/*
IAddressService.java
Author: Melisa Bhixa
Date: 15 June 2022
 */

package za.ac.cput.service.location;

import za.ac.cput.domain.location.Address;
import za.ac.cput.service.IService;

import java.util.Optional;


public interface IAddressService extends IService<Address, String> {

    Optional<Address> findById(String s);
}
