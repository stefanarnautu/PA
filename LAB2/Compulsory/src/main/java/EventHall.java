import java.util.Objects;

public class EventHall extends Room{

   private boolean videoProjector;

    public EventHall(String name, Type type, int capacity,boolean videoProjector) {
        super(name, type, capacity);
        this.videoProjector=videoProjector;
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

    public void setVideoProjector(boolean videoProjector) {
        this.videoProjector = videoProjector;
    }

    public boolean getVideoProjector()
    {
        return this.videoProjector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity && Objects.equals(name, room.name) && type == room.type;
    }

}
