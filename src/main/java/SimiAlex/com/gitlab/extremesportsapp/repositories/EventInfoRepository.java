package SimiAlex.com.gitlab.extremesportsapp.repositories;

import SimiAlex.com.gitlab.extremesportsapp.model.EventInfo;
import SimiAlex.com.gitlab.extremesportsapp.model.SportType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventInfoRepository extends CrudRepository<EventInfo, Long> {

    @Query(value = "SELECT e FROM EventInfo e WHERE e.sportType IN :sportTypesParam AND e.beginDate < :beginDateUser AND e.endDate > :endDateUser")
    public List<EventInfo> getEventsBySportTypeAndPeriod(List<SportType> sportTypesParam, LocalDate beginDateUser, LocalDate endDateUser);
}
