/*
AddressController.java
Author: Melisa Bhixa
Date: 18-06-2022
 */
package za.ac.cput.controller.location;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.location.City;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.service.location.IAddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school_db/city")

public class AddressController {

 @Autowired
    private IAddressService service;

    @PostMapping
 public ResponseEntity<Address> save (@Valid @RequestBody Address address) {
        Address newAddress;
        City newCity;
        try {
            newAddress = AddressFactory.createAddress(address.getUnitNumber(),address.getComplexName(), address.getStreetNumber(),
                    address.getStreetName(),address.getPostalCode(), address.getCity());
        }
        catch(IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Address save = service.save(newAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Address> read(@PathVariable String id) {
     Address address = this.service.read(id).orElseThrow(
             () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
     );
     return ResponseEntity.ok(address);
    }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Object> delete(@PathVariable String id){
       this.service.deleteById(id);
       return ResponseEntity.noContent().build();
   }

    @GetMapping("all")
    public ResponseEntity<List<Address>> findAll() {
        List <Address> address = this.service.findAll();
        return ResponseEntity.ok(address);
    }

}
