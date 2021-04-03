package SimiAlex.com.gitlab.extremesportsapp.controllers;

import SimiAlex.com.gitlab.extremesportsapp.model.Country;
import SimiAlex.com.gitlab.extremesportsapp.model.Region;
import SimiAlex.com.gitlab.extremesportsapp.model.request.RegionRequestModel;
import SimiAlex.com.gitlab.extremesportsapp.services.CountryService;
import SimiAlex.com.gitlab.extremesportsapp.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "regions")
public class RegionController {

    //fields
    @Autowired
    private RegionService regionService;

    @Autowired
    private CountryService countryService;

    //methods
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Region> addRegion(@RequestBody RegionRequestModel regionRequestModel)
    {
        //find Country in database
        Country country = countryService.findCountry(regionRequestModel.getCountryId());

        //create new Region object and set it up
        Region region = new Region();
        region.setCountry(country);
        region.setRegionName(regionRequestModel.getRegionName());

        //persist the Region object
        return new ResponseEntity<Region>(regionService.addRegion(region), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Region>> getRegions()
    {
        return new ResponseEntity<List<Region>>(regionService.findAllRegions(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Region> getRegion(@PathVariable Long id)
    {
        return new ResponseEntity<Region>(regionService.findRegion(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRegion(@RequestBody RegionRequestModel regionRequestModel)
    {
        //get the Country and the Region from database using the id's from the request
        Region region = regionService.findRegion(regionRequestModel.getId());
        Country country = countryService.findCountry(regionRequestModel.getCountryId());

        //update the Region object
        region.setCountry(country);
        region.setRegionName(regionRequestModel.getRegionName());

        //persist the updated Region
        regionService.updateRegion(region);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id)
    {
        regionService.deleteRegion(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
