package SimiAlex.com.gitlab.extremesportsapp.services;

import SimiAlex.com.gitlab.extremesportsapp.model.SportType;
import SimiAlex.com.gitlab.extremesportsapp.repositories.SportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportTypeService {

    @Autowired
    private SportTypeRepository sportTypeRepository;

    //methods
    public SportType addSportType(SportType sportType)
    {
        return sportTypeRepository.save(sportType);
    }

    public SportType findSportTypeById(Long id)
    {
        return sportTypeRepository.findById(id).orElseThrow();
    }

    public List<SportType> findAllSportTypes()
    {
        return (List<SportType>) sportTypeRepository.findAll();
    }

    public SportType updateSportType(SportType sportType)
    {
        return sportTypeRepository.save(sportType);
    }

    public void deleteSportType(Long id)
    {
        sportTypeRepository.deleteById(id);
    }
}
