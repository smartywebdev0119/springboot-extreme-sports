package SimiAlex.com.gitlab.extremesportsapp.controllers;

import SimiAlex.com.gitlab.extremesportsapp.model.Destination;
import SimiAlex.com.gitlab.extremesportsapp.model.EventInfo;
import SimiAlex.com.gitlab.extremesportsapp.model.SportType;
import SimiAlex.com.gitlab.extremesportsapp.model.request.EventInfoRequestModel;
import SimiAlex.com.gitlab.extremesportsapp.repositories.DestinationRepository;
import SimiAlex.com.gitlab.extremesportsapp.repositories.SportTypeRepository;
import SimiAlex.com.gitlab.extremesportsapp.services.EventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event-info")
public class EventInfoController {

    //fields
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private SportTypeRepository sportTypeRepository;

    @Autowired
    private EventInfoService eventInfoService;

    //methods
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventInfo> createEventInfo(@RequestBody EventInfoRequestModel eventInfoRequestModel)
    {
        //recover destination and sport type from database
        Destination destination = destinationRepository.findById(eventInfoRequestModel.getDestinationId()).orElseThrow();
        SportType sportType = sportTypeRepository.findById(eventInfoRequestModel.getSportTypeId()).orElseThrow();

        //populate event info object
        EventInfo eventInfo = new EventInfo();
        eventInfo.setDestination(destination);
        eventInfo.setSportType(sportType);
        eventInfo.setPricePerDay(eventInfoRequestModel.getPricePerDay());
        eventInfo.setBeginDate(eventInfoRequestModel.getBeginDate());
        eventInfo.setEndDate(eventInfoRequestModel.getEndDate());

        //persist event info object
        return new ResponseEntity<EventInfo>(eventInfoService.createEventInfo(eventInfo), HttpStatus.CREATED);
    }

}
