public class Room {
    private String name;
    private int capacity;
    private Type typeRoom;

    public Room(String name,Type type,int capacity)
    {
        this.name=name;
        this.capacity=capacity;
        this.typeRoom=type;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTypeRoom(Type typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public Type getTypeRoom() {
        return typeRoom;
    }
    public String toString() {
        return name + "(cap=" + capacity+ ", " +typeRoom +")" ;
    }
}
