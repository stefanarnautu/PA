import java.util.Objects;

abstract class Room {
     protected String name;
     protected int capacity;

     public abstract void setName(String name);
     public abstract void setCapacity(int capacity);
     public abstract String getName();
     public abstract int getCapacity();
     public abstract String toString();
     public abstract boolean equals(Object o);

     //Nu stiu daca se poate sau nu face constructorul abstract (nu am reusit)
     public Room(String name, int capacity)
    {
        this.name=name;
        this.capacity=capacity;
    }
}
