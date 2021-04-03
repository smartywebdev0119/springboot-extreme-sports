package SimiAlex.com.gitlab.extremesportsapp.services;

import SimiAlex.com.gitlab.extremesportsapp.model.Region;
import SimiAlex.com.gitlab.extremesportsapp.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    //methods
    public Region addRegion(Region region)
    {
        return regionRepository.save(region);
    }

    public Region findRegion(Long id)
    {
        return regionRepository.findById(id).orElseThrow();
    }

    public List<Region> findAllRegions()
    {
        return (List<Region>) regionRepository.findAll();
    }

    public Region updateRegion(Region region)
    {
        return regionRepository.save(region);
    }

    public void deleteRegion(Long id)
    {
        regionRepository.deleteById(id);
    }
}
