package Repositories;

import javax.persistence.*;

@Entity
@NamedQuery(name = "ContinentsEntity.getLastId", query = "SELECT e.id from ContinentsEntity e order by e.id DESC")
@NamedQuery(name = "ContinentsEntity.verify", query = "SELECT count(e.id) from ContinentsEntity e where e.name=?1")
@NamedQuery(name = "ContinentsEntity.findByName", query = "SELECT e from ContinentsEntity e where e.name=:nameSearched")
@Table(name = "continents", schema = "public", catalog = "lab8pa")
public class ContinentsEntity {
    @Id
    @Basic
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContinentsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
