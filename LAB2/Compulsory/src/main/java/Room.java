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
}
