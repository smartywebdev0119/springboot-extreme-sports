package SimiAlex.com.gitlab.extremesportsapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "events_info")
public class EventInfo
{
    // fields
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRICE_PER_DAY", nullable = false)
    private Double pricePerDay;

    @Column(name = "BEGIN_DATE", nullable = false, columnDefinition = "DATE")
    private LocalDate beginDate;

    @Column(name = "END_DATE", nullable = false, columnDefinition = "DATE")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DESTINATION_ID")
    private Destination destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SPORT_TYPE_ID")
    private SportType sportType;

    // methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventInfo eventInfo = (EventInfo) o;
        return Objects.equals(id, eventInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
