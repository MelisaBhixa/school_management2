/* CityController.java Class
 * Entity for City Controller
 * Author: Panashe Muinzani(218186568)
 * Date: 16 June 2022
 */

package za.ac.cput.controller.location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.location.City;
import za.ac.cput.domain.location.Country;
import za.ac.cput.factory.location.CityFactory;
import za.ac.cput.service.location.ICityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_db/city")

public class CityController {

    @Autowired
    private ICityService service;

    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city) {
        Country newCountry;
        City newCity;
        try {
            newCity = CityFactory.createCity(city.getId(), city.getName(), city.getCountry());
        }
        catch(IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        City save = service.save(newCity);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id) {
        City city = this.service.read(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<City>> findAll() {
        List <City> city = this.service.findAll();
        return ResponseEntity.ok(city);
    }
}

