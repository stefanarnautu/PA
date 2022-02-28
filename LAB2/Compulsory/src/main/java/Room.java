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
    public String toString()
    {
      return name + " " + type + " " + capacity;
    }
}
