package SimiAlex.com.gitlab.extremesportsapp.controllers;

import SimiAlex.com.gitlab.extremesportsapp.model.SportType;
import SimiAlex.com.gitlab.extremesportsapp.services.SportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sport_type")
public class SportTypeController {

    @Autowired
    private SportTypeService sportTypeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<SportType> addSportType(@RequestBody SportType sportType)
    {
        return new ResponseEntity<SportType>(sportTypeService.addSportType(sportType), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SportType>> getSportTypes()
    {
        return new ResponseEntity<List<SportType>>(sportTypeService.findAllSportTypes(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<SportType> getSportType(@PathVariable Long id)
    {
        return new ResponseEntity<SportType>(sportTypeService.findSportTypeById(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SportType> updateSportType(@RequestBody SportType sportType)
    {
        SportType sportTypeTemp = sportTypeService.findSportTypeById(sportType.getId());
        sportTypeTemp.setSportName(sportType.getSportName());
        return new ResponseEntity<SportType>(sportTypeService.updateSportType(sportTypeTemp), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteSportType(@PathVariable Long id)
    {
        sportTypeService.deleteSportType(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
