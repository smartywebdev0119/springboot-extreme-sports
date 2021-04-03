package SimiAlex.com.gitlab.extremesportsapp.model.request;

public class RegionRequestModel {

    //fields
    private Long id;
    private Long countryId;
    private String regionName;

    //methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
