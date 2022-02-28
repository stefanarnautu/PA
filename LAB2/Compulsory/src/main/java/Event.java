public class Event {
    String name;
    int participants;
    int startTime;
    int endTime;
    Type type;
    public Event(String name,int participants,int startTime, int endTime,Type type)
    {
        this.name=name;
        this.participants=participants;
        this.startTime=startTime;
        this.endTime=endTime;
        this.type=type;
    }
    public String toString()
    {
        return name + " " + participants + " " + startTime + " " + endTime + " " + type;
    }
}
