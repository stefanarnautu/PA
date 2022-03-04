import java.util.Objects;

abstract class Room {
     protected String name;
     protected Type type;
     protected int capacity;

     public abstract void setName(String name);
     public abstract void setType(Type type);
     public abstract void setCapacity(int capacity);
     public abstract String getName();
     public abstract Type getType();
     public abstract int getCapacity();
     public abstract String toString();
     public abstract boolean equals(Object o);

     public Room(String name,Type type, int capacity)
    {
        this.name=name;
        this.type=type;
        this.capacity=capacity;
    }
}
