package SimiAlex.com.gitlab.extremesportsapp.services;

import SimiAlex.com.gitlab.extremesportsapp.model.EventInfo;
import SimiAlex.com.gitlab.extremesportsapp.repositories.EventInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventInfoService {

    //fields
    @Autowired
    private EventInfoRepository eventInfoRepository;

    //methods
    public EventInfo createEventInfo(EventInfo eventInfo)
    {
        return eventInfoRepository.save(eventInfo);
    }

    public EventInfo getEventInfoById(Long id)
    {
        return eventInfoRepository.findById(id).orElseThrow();
    }

    public List<EventInfo> getEvents()
    {
        return (List<EventInfo>) eventInfoRepository.findAll();
    }

    public EventInfo updateEventInfo(EventInfo eventInfo)
    {
        return eventInfoRepository.save(eventInfo);
    }

    public void deleteEventInfo(Long id)
    {
        eventInfoRepository.deleteById(id);
    }
}
