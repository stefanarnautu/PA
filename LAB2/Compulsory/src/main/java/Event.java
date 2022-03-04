import java.util.Objects;

public class Event {
    private String name;
    private int participants;
    private int startTime;
    private int endTime;
    private Type type;
    public Event(String name,int participants,int startTime, int endTime,Type type)
    {
        this.name=name;
        this.participants=participants;
        this.startTime=startTime;
        this.endTime=endTime;
        this.type=type;
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
    public void setType(Type newType)
    {
        this.type=newType;
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
    public Type getType() {
        return type;
    }

    public String toString()
    {
        return name + " " + participants + " " + startTime + " " + endTime + " " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return participants == event.participants && startTime == event.startTime && endTime == event.endTime && Objects.equals(name, event.name) && type == event.type;
    }
}

