package SimiAlex.com.gitlab.extremesportsapp.repositories;

import SimiAlex.com.gitlab.extremesportsapp.model.SportType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportTypeRepository extends CrudRepository<SportType, Long> {

    @Query(value = "SELECT s FROM SportType s WHERE s.sportName IN :sportTypeList")
    public List<SportType> getSportTypesByName(List<String> sportTypeList);
}
