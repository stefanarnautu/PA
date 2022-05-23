package data;

import javax.persistence.*;
import java.util.Objects;

@Entity

@NamedQuery(name = "AccountEntity.getAll", query = "SELECT e from AccountsEntity e")

@Table(name = "accounts", schema = "public", catalog = "lab11pa")
public class AccountsEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
        AccountsEntity that = (AccountsEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AccountsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
