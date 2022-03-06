import java.util.ArrayList;

public class InstantaProblema {

    //Am creat array-uri pentru sali de clasa si de curs separat pentru a sti cate sunt de fiecare si pentru ca suntabiecte diferite
    //Acest lucru ma ajuta sa distribui cursurile in salile de curs si seminariile in salile de laborator
    ArrayList<Laboratory> saliDeClasa=new ArrayList<Laboratory>();
    ArrayList<EventHall> saliDeCurs=new ArrayList<EventHall>();
    ArrayList<Event>cursuriSiSeminarii=new ArrayList<Event>();

    public InstantaProblema()
    {
    }
    public void addLaboratory(String name, int capacity)
    {
        Laboratory room=new Laboratory(name,capacity);
       //Cautam sa vedem daca exista inainte sa o adaugam
        for(Laboratory r:saliDeClasa)
            if(room.equals(r))
                System.out.println("Sala de curs existenta.");
        saliDeClasa.add(room);
    }
    public void addEventHall(String name, int capacity,boolean videoProjector)
    {
        EventHall room=new EventHall(name,capacity,videoProjector);
        for(EventHall r:saliDeCurs)
            if(room.equals(r))
                System.out.println("Sala de clasa existenta.");
        saliDeCurs.add(room);
    }
    public void addEvent(String name,int participants,int startTime, int endTime)
    {
        Event event=new Event(name,participants,startTime,endTime);
        for(Event e:cursuriSiSeminarii)
            if(event.equals(e))
                System.out.println("Eveniment deja existent.");
        cursuriSiSeminarii.add(event);
    }

    //Cautarile la afisarea oricarui eveniment se face in functie de nume

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