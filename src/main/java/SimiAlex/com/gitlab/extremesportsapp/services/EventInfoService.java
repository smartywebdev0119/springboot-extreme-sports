package SimiAlex.com.gitlab.extremesportsapp.services;

import SimiAlex.com.gitlab.extremesportsapp.model.EventInfo;
import SimiAlex.com.gitlab.extremesportsapp.repositories.EventInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
