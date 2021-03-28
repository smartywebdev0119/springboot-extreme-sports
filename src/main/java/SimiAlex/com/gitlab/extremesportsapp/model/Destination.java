package SimiAlex.com.gitlab.extremesportsapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "destinations")
public class Destination
{
    //fields
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESTINATION_NAME", nullable = false)
    private String destinationName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    //methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return destinationName;
    }

    public void setName(String name) {
        this.destinationName = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
