package Repositories;

import javax.persistence.*;

@Entity

@NamedQuery(name = "CitieswithpopulationEntity.getLastId", query = "SELECT e.id from CitieswithpopulationEntity e order by e.id DESC")
@NamedQuery(name = "CitieswithpopulationEntity.verify", query = "SELECT count(e.id) from CitieswithpopulationEntity e where e.name=?1")
@NamedQuery(name = "CitieswithpopulationEntity.findByName", query = "SELECT e from CitieswithpopulationEntity e where e.name=:nameSearched")
@NamedQuery(name = "CitieswithpopulationEntity.citiesFromTheSameCountryPopolation", query = "SELECT sum(e.population)" +
        " from CitieswithpopulationEntity e " +
        "where e.country=:nameSearched and e.population>:minPopulation and e.population<:maxPopulation")

@Table(name = "citieswithpopulation", schema = "public", catalog = "lab8pa")
public class CitieswithpopulationEntity {
    @Id
    @Basic
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "capital")
    private String capital;
    @Basic
    @Column(name = "latitude")
    private String latitude;
    @Basic
    @Column(name = "longitude")
    private String longitude;
    @Basic
    @Column(name = "population")
    private Integer population;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitieswithpopulationEntity that = (CitieswithpopulationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (population != null ? !population.equals(that.population) : that.population != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CitieswithpopulationEntity{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", population=" + population +
                '}';
    }
}
