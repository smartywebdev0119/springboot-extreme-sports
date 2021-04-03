package SimiAlex.com.gitlab.extremesportsapp.services;

import SimiAlex.com.gitlab.extremesportsapp.model.Destination;
import SimiAlex.com.gitlab.extremesportsapp.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    //methods
    public Destination addDestination(Destination destination)
    {
        return destinationRepository.save(destination);
    }

    public Destination findDestination(Long id)
    {
        return destinationRepository.findById(id).orElseThrow();
    }

    public List<Destination> findAllDestinations()
    {
        return (List<Destination>) destinationRepository.findAll();
    }

    public Destination updateDestination(Destination destination)
    {
        return destinationRepository.save(destination);
    }

    public void deleteDestination(Long id)
    {
        destinationRepository.deleteById(id);
    }
}
