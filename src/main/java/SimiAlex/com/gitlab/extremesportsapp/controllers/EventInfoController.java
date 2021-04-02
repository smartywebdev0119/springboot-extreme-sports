package SimiAlex.com.gitlab.extremesportsapp.controllers;

import SimiAlex.com.gitlab.extremesportsapp.model.Destination;
import SimiAlex.com.gitlab.extremesportsapp.model.EventInfo;
import SimiAlex.com.gitlab.extremesportsapp.model.SportType;
import SimiAlex.com.gitlab.extremesportsapp.model.request.EventInfoRequestModel;
import SimiAlex.com.gitlab.extremesportsapp.repositories.DestinationRepository;
import SimiAlex.com.gitlab.extremesportsapp.repositories.EventInfoRepository;
import SimiAlex.com.gitlab.extremesportsapp.repositories.SportTypeRepository;
import SimiAlex.com.gitlab.extremesportsapp.services.EventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @Autowired
    private EventInfoRepository eventInfoRepository;

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

    @GetMapping(path = "{id}")
    public ResponseEntity<EventInfo> getEventInfoById(@PathVariable Long id)
    {
        return new ResponseEntity<EventInfo>(eventInfoService.getEventInfoById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EventInfo>> getEvents()
    {
        return new ResponseEntity<List<EventInfo>>(eventInfoService.getEvents(), HttpStatus.OK);
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventInfo> updateEventInfo(@RequestBody EventInfoRequestModel eventInfoRequestModel, @PathVariable Long id)
    {
        //recover event info from database
        EventInfo eventInfo = eventInfoService.getEventInfoById(id);

        //recover destination and sport type from database
        Destination destination = destinationRepository.findById(eventInfoRequestModel.getDestinationId()).orElseThrow();
        SportType sportType = sportTypeRepository.findById(eventInfoRequestModel.getSportTypeId()).orElseThrow();

        //populate event info object
        eventInfo.setDestination(destination);
        eventInfo.setSportType(sportType);
        eventInfo.setPricePerDay(eventInfoRequestModel.getPricePerDay());
        eventInfo.setBeginDate(eventInfoRequestModel.getBeginDate());
        eventInfo.setEndDate(eventInfoRequestModel.getEndDate());

        //update event info
        return new ResponseEntity<EventInfo>(eventInfoService.updateEventInfo(eventInfo), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteEventInfo(@PathVariable Long id)
    {
        eventInfoService.deleteEventInfo(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(path = "search")
    public ResponseEntity<List<EventInfo>> getEventsForClientSearch(@RequestParam("sportTypes")List<String> sportTypeParam,
                                                              @RequestParam("beginDate")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate beginDateParam,
                                                              @RequestParam("endDate")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDateParam)
    {
        List<SportType> sportTypeList = sportTypeRepository.getSportTypesByName(sportTypeParam);
        return new ResponseEntity<List<EventInfo>>(eventInfoRepository.getEventsBySportTypeAndPeriod(sportTypeList, beginDateParam, endDateParam), HttpStatus.OK);
    }
}
