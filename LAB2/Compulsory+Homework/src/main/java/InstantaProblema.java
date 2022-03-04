import java.util.ArrayList;

public class InstantaProblema {
    ArrayList<Laboratory> saliDeClasa=new ArrayList<Laboratory>();
    ArrayList<EventHall> saliDeCurs=new ArrayList<EventHall>();
    ArrayList<Event>cursuriSiSeminarii=new ArrayList<Event>();

    public InstantaProblema()
    {
    }
    public void addLaboratory(String name,Type type, int capacity)
    {
        Laboratory room=new Laboratory(name,type,capacity);
        for(Laboratory r:saliDeClasa)
            if(room.equals(r))
                System.out.println("Sala de curs existenta.");
        saliDeClasa.add(room);
    }
    public void addEventHall(String name,Type type, int capacity,boolean videoProjector)
    {
        EventHall room=new EventHall(name,type,capacity,videoProjector);
        for(EventHall r:saliDeCurs)
            if(room.equals(r))
                System.out.println("Sala de clasa existenta.");
        saliDeCurs.add(room);
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
            if (numeEvent.equals(e.getName())) {
                return e.toString();
            }
        return "Nu exista";
    }
    public String afiseazaLaborator(String numeRoom)
    {
        for (Room r : saliDeClasa)
            if (numeRoom.equals(r.getName())) {
                return r.toString();
            }
        return "Nu exista";
    }
    public String afiseazaSalaDeCurs(String numeRoom)
    {
        for (Room r : saliDeCurs)
            if (numeRoom.equals(r.getName())) {
                return r.toString();
            }
        return "Nu exista";
    }
}