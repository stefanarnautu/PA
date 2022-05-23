package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "alldata", schema = "public", catalog = "ProiectPA")
public class AlldataEntity {
    @Id
    @Basic
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "state_id")
    private Integer stateId;
    @Basic
    @Column(name = "state_code")
    private String stateCode;
    @Basic
    @Column(name = "state_name")
    private String stateName;
    @Basic
    @Column(name = "country_id")
    private Integer countryId;
    @Basic
    @Column(name = "country_code")
    private String countryCode;
    @Basic
    @Column(name = "country_name")
    private String countryName;
    @Basic
    @Column(name = "latitude")
    private String latitude;
    @Basic
    @Column(name = "longitude")
    private String longitude;
    @Basic
    @Column(name = "wikidataid")
    private String wikidataid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getWikidataid() {
        return wikidataid;
    }

    public void setWikidataid(String wikidataid) {
        this.wikidataid = wikidataid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlldataEntity that = (AlldataEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(stateId, that.stateId) && Objects.equals(stateCode, that.stateCode) && Objects.equals(stateName, that.stateName) && Objects.equals(countryId, that.countryId) && Objects.equals(countryCode, that.countryCode) && Objects.equals(countryName, that.countryName) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(wikidataid, that.wikidataid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stateId, stateCode, stateName, countryId, countryCode, countryName, latitude, longitude, wikidataid);
    }

}
