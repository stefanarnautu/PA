package entities;

import javax.persistence.*;

@Entity
@NamedQuery(name = "StatesEntity.verify", query = "SELECT count(e.stateId) from StatesEntity e where e.stateName=?1")
@Table(name = "states", schema = "public", catalog = "ProiectPA")
public class StatesEntity {
    @Id
    @Basic
    @Column(name = "state_id")
    private int stateId;
    @Basic
    @Column(name = "country_id")
    private Integer countryId;
    @Basic
    @Column(name = "state_code")
    private String stateCode;
    @Basic
    @Column(name = "state_name")
    private String stateName;

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatesEntity that = (StatesEntity) o;

        if (stateId != that.stateId) return false;
        if (countryId != null ? !countryId.equals(that.countryId) : that.countryId != null) return false;
        if (stateCode != null ? !stateCode.equals(that.stateCode) : that.stateCode != null) return false;
        if (stateName != null ? !stateName.equals(that.stateName) : that.stateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stateId;
        result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
        result = 31 * result + (stateCode != null ? stateCode.hashCode() : 0);
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        return result;
    }
}
