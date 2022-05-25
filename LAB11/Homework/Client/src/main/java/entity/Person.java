package entity;

public class Person {
    private int id;
    private String name;
    private Integer entries;

    public Person() {
        this.id = 0;
        this.name = null;
        this.entries = 0;
    }

    public int getId() {
        return id;
    }

    public Integer getEntey() {
        return entries;
    }

    public void setEntey(Integer entey) {
        this.entries = entey;
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
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
