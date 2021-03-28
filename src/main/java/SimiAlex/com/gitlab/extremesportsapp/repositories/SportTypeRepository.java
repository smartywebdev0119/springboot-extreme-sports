package SimiAlex.com.gitlab.extremesportsapp.repositories;

import SimiAlex.com.gitlab.extremesportsapp.model.SportType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportTypeRepository extends CrudRepository<SportType, Long> {
}
