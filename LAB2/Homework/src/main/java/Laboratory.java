import java.util.Objects;

public class Laboratory extends Room{
    public Laboratory(String name, int capacity) {
        super(name, capacity);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString()
    {
        return name + " " + " " + capacity ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity && Objects.equals(name, room.name);
    }
}
