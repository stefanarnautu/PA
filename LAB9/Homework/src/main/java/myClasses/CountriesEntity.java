package myClasses;

import javax.persistence.*;

@Entity
@NamedQuery(name = "CountriesEntity.getLastId", query = "SELECT e.id from CountriesEntity e order by e.id DESC")
@NamedQuery(name = "CountriesEntity.verify", query = "SELECT count(e.id) from CountriesEntity e where e.name=?1")
@NamedQuery(name = "CountriesEntity.findByName", query = "SELECT e.id from CountriesEntity e where e.name=:nameSearched")
@NamedQuery(name = "CountriesEntity.findObjectByName", query = "SELECT e from CountriesEntity e where e.id=:idSearched")
@Table(name = "countries", schema = "public", catalog = "lab8pa")
public class CountriesEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "continent")
    private int continent;
    @Id
    @Basic
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name="id", nullable = false, insertable = false, updatable = false)
    private ContinentsEntity conEnt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getContinent() {
        return continent;
    }

    public void setContinent(int continent) {
        this.continent = continent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContinentsEntity getConEnt() {
        return conEnt;
    }

    public void setConEnt(ContinentsEntity conEnt) {
        this.conEnt = conEnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountriesEntity that = (CountriesEntity) o;

        if (continent != that.continent) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + continent;
        result = 31 * result + id;
        return result;
    }

    @ManyToOne(optional = false)
    private ContinentsEntity continentsEntities;

    public ContinentsEntity getContinentsEntities() {
        return continentsEntities;
    }

    public void setContinentsEntities(ContinentsEntity continentsEntities) {
        this.continentsEntities = continentsEntities;
    }

    @Override
    public String toString() {
        return "A";
    }
}
