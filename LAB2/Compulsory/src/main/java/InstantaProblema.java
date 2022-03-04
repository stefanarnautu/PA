import java.util.ArrayList;

public class InstantaProblema {
    ArrayList<Room> saliDeClasa=new ArrayList<Room>();
    ArrayList<Event>cursuriSiSeminarii=new ArrayList<Event>();

    public InstantaProblema()
    {
    }
    public void addRoom(String name,Type type, int capacity)
    {
        Room room=new Room(name,type,capacity);
        for(Room r:saliDeClasa)
            if(room.equals(r))
                System.out.println("Sala de clasa existenta.");
        saliDeClasa.add(room);
    }
    public void addEvent(String name,int participants,int startTime, int endTime,Type type)
    {
        Event event=new Event(name,participants,startTime,endTime,type);
        for(Event e:cursuriSiSeminarii)
            if(event.equals(e))
                System.out.println("Eveniment deja existent.");
        cursuriSiSeminarii.add(event);
    }
    public String afiseazaEvent(String numeEvent)
    {
        for (Event e : cursuriSiSeminarii)
            if (numeEvent == e.getName()) {
                return e.toString();
            }
        return "Nu exista";
    }
    public String afiseazaRoom(String numeRoom)
    {
        for (Room r : saliDeClasa)
            if (numeRoom == r.getName()) {
                return r.toString();
            }
        return "Nu exista";
    }
}