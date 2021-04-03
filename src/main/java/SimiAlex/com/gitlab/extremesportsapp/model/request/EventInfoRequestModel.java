package SimiAlex.com.gitlab.extremesportsapp.model.request;

import java.time.LocalDate;

public class EventInfoRequestModel {

    //fields
    private Long sportId;
    private Double pricePerDay;
    private Long destinationId;
    private Long sportTypeId;
    private LocalDate beginDate;
    private LocalDate endDate;

    //methods
    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public Long getSportTypeId() {
        return sportTypeId;
    }

    public void setSportTypeId(Long sportTypeId) {
        this.sportTypeId = sportTypeId;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
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
}
