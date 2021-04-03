package SimiAlex.com.gitlab.extremesportsapp.controllers;

import SimiAlex.com.gitlab.extremesportsapp.model.Country;
import SimiAlex.com.gitlab.extremesportsapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "countries")
public class CountryController {

    //fields
    @Autowired
    private CountryService countryService;

    //methods
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Country> addCountry(@RequestBody Country country)
    {
        return new ResponseEntity<Country>(countryService.addCountry(country), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> getAllCountries()
    {
        return new ResponseEntity<List<Country>>(countryService.findAllCountries(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Country> getCountryById(@PathVariable Long id)
    {
        return new ResponseEntity<Country>(countryService.findCountry(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCountry(@RequestBody Country country)
    {
        countryService.updateCountry(country);
        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id)
    {
        countryService.deleteCountry(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
