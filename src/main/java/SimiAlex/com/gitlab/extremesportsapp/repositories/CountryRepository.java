package SimiAlex.com.gitlab.extremesportsapp.repositories;

import SimiAlex.com.gitlab.extremesportsapp.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
