package SimiAlex.com.gitlab.extremesportsapp.services;

import SimiAlex.com.gitlab.extremesportsapp.model.Country;
import SimiAlex.com.gitlab.extremesportsapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //methods
    public Country addCountry(Country country)
    {
        return countryRepository.save(country);
    }

    public Country findCountry(Long id)
    {
        return countryRepository.findById(id).orElseThrow();
    }

    public List<Country> findAllCountries()
    {
        return (List<Country>) countryRepository.findAll();
    }

    public Country updateCountry(Country country)
    {
        return countryRepository.save(country);
    }

    public void deleteCountry(Long id)
    {
        countryRepository.deleteById(id);
    }
}
