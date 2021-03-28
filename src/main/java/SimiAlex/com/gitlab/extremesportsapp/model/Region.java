package SimiAlex.com.gitlab.extremesportsapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "regions")
public class Region
{
    // fields
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REGION_NAME", nullable = false)
    private String regionName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    // methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return regionName;
    }

    public void setName(String name) {
        this.regionName = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return id.equals(region.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
