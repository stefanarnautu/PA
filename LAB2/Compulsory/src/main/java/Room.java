import java.util.Objects;

public class Room {
    String name;
    Type type;
    int capacity;

    public Room(String name,Type type, int capacity)
    {
        this.name=name;
        this.type=type;
        this.capacity=capacity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getName() {
        return name;
    }
    public Type getType() {
        return type;
    }
    public int getCapacity() {
        return capacity;
    }

    public String toString()
    {
      return name + " " + " " + capacity+ " " +type ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity && Objects.equals(name, room.name) && type == room.type;
    }

    //Este necesar hashCode?

  /*  @Override
    public int hashCode() {
        return Objects.hash(name, type, capacity);
    }*/
}
