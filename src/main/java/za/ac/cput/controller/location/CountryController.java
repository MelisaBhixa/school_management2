package za.ac.cput.controller.location;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.location.Country;
import za.ac.cput.factory.location.CountryFactory;
import za.ac.cput.service.location.ICountryService;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("School_management2/country")
public class CountryController {
    private final ICountryService iCountryService;

    @Autowired
    public CountryController(ICountryService iCountryService){
        this.iCountryService = iCountryService;
    }

    @PostMapping("save")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country){
        Country newCountry;
        try {
            newCountry = CountryFactory.createCountry(country.getId(), country.getName());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Country save = iCountryService.save(newCountry);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id){
        Country country = this.iCountryService.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id) {
        this.iCountryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Country>>findAll(){
        List <Country> country = this.iCountryService.findAll();
        return ResponseEntity.ok(country);

    }
}