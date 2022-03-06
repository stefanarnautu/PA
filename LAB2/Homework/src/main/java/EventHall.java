import java.util.Objects;

/**
 * Clasa exitinsa de la Room
 * Contime implementarea metodelor din Room
 */

public class EventHall extends Room{

   private boolean videoProjector;

    public EventHall(String name, int capacity,boolean videoProjector) {
        super(name, capacity);
        this.videoProjector=videoProjector;
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
        return capacity == room.capacity && Objects.equals(name, room.name);
    }

}
