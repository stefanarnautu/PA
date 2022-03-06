import java.util.Objects;

public class Event {
    protected String name;
    protected int participants;
    protected int startTime;
    protected int endTime;
    public Event(String name,int participants,int startTime, int endTime)
    {
        this.name=name;
        this.participants=participants;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public void setName(String newName)
    {
        this.name=newName;
    }
    public void setNumberOfParticipants(int newNumber)
    {
        this.participants=newNumber;
    }
    public void setStartTime(int newStartData)
    {
        this.startTime=newStartData;
    }
    public void setEndTime(int newEndData)
    {
        this.endTime=newEndData;
    }

    public String getName() {
        return name;
    }
    public int getParticipants() {
        return participants;
    }
    public int getStartTime() {
        return startTime;
    }
    public int getEndTime() {
        return endTime;
    }

    public String toString()
    {
        return name + " " + participants + " " + startTime + " " + endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return participants == event.participants && startTime == event.startTime && endTime == event.endTime && Objects.equals(name, event.name);
    }

    //Este necesar hashCode?
    /*  @Override
    public int hashCode() {
        return Objects.hash(...);
    }*/
}

