package SimiAlex.com.gitlab.extremesportsapp.controllers;

import SimiAlex.com.gitlab.extremesportsapp.model.Destination;
import SimiAlex.com.gitlab.extremesportsapp.model.request.DestinationRequestModel;
import SimiAlex.com.gitlab.extremesportsapp.services.DestinationService;
import SimiAlex.com.gitlab.extremesportsapp.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "destinations")
public class DestinationController {

    //fields
    @Autowired
    private DestinationService destinationService;

    @Autowired
    private RegionService regionService;

    //methods
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Destination> addDestination(@RequestBody DestinationRequestModel destinationRequestModel)
    {
        //create new Destination and set the name and Region from the destinationRequestModel
        Destination destination = new Destination();
        destination.setDestinationName(destinationRequestModel.getDestinationName());
        destination.setRegion(regionService.findRegion(destinationRequestModel.getRegionId()));

        return new ResponseEntity<Destination>(destinationService.addDestination(destination), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Destination>> getDestinations()
    {
        return new ResponseEntity<List<Destination>>(destinationService.findAllDestinations(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Destination> getDestination(@PathVariable Long id)
    {
        return new ResponseEntity<Destination>(destinationService.findDestination(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateDestination(@RequestBody DestinationRequestModel destinationRequestModel)
    {
        //get Destination object from database
        Destination destination = destinationService.findDestination(destinationRequestModel.getId());

        //update Destination object
        destination.setDestinationName(destinationRequestModel.getDestinationName());
        destination.setRegion(regionService.findRegion(destinationRequestModel.getRegionId()));

        //persist updated Destination object
        destinationService.updateDestination(destination);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id)
    {
        destinationService.deleteDestination(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
