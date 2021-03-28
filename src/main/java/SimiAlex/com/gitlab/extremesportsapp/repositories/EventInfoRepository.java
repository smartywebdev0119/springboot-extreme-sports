package SimiAlex.com.gitlab.extremesportsapp.repositories;

import SimiAlex.com.gitlab.extremesportsapp.model.EventInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventInfoRepository extends CrudRepository<EventInfo, Long> {
}
