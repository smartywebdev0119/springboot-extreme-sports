package SimiAlex.com.gitlab.extremesportsapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sport_types")
public class SportType
{
    //fields
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SPORT_NAME", nullable = false)
    private String sportName;

    //methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return sportName;
    }

    public void setName(String name) {
        this.sportName = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportType sportType = (SportType) o;
        return id.equals(sportType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
