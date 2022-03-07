import java.util.Objects;
import java.util.Date;

public class Event {
    protected String name;
    protected int participants;
    protected Date dataStart=new Date();
    public Event(String name,int participants,int oraStart)
    {
        this.name=name;
        this.participants=participants;
        this.dataStart.setHours(oraStart);
    }

    public void setName(String newName)
    {
        this.name=newName;
    }
    public void setNumberOfParticipants(int newNumber)
    {
        this.participants=newNumber;
    }

    public Date getDataStart() {
        return dataStart;
    }

    public String getName() {
        return name;
    }
    public int getParticipants() {
        return participants;
    }

    public String toString()
    {
        return name + " " + participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return participants == event.participants && Objects.equals(name, event.name);
    }

    //Este necesar hashCode?
    /*  @Override
    public int hashCode() {
        return Objects.hash(...);
    }*/
}

