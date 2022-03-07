import java.util.ArrayList;

/**
 * Aceasta clasa este folosita pentru a stoca toate laboratoarele/cursurile pentru a putea fi folosite in generarea solutiei
 * (solutia va fi generata unui obiect de acest tip)
 */

public class InstantaProblema {

    //Am creat array-uri pentru sali de clasa si de curs separat pentru a sti cate sunt de fiecare si pentru ca suntabiecte diferite
    //Acest lucru ma ajuta sa distribui cursurile in salile de curs si seminariile in salile de laborator
    ArrayList<Laboratory> saliDeClasa=new ArrayList<Laboratory>();
    ArrayList<EventHall> saliDeCurs=new ArrayList<EventHall>();
    ArrayList<Event>cursuriSiSeminarii=new ArrayList<Event>();

    public InstantaProblema()
    {
    }

    /**
     * Adaugarea unui laborator nou in Array-ul dedicat laboratoarelor(saliDeClasa)
     * @param name numele laboratorului
     * @param capacity capacitatea ceruta
     */
    public void addLaboratory(String name, int capacity)
    {
        Laboratory room=new Laboratory(name,capacity);
       //Cautam sa vedem daca exista inainte sa o adaugam
        for(Laboratory r:saliDeClasa)
            if(room.equals(r))
                System.out.println("Sala de curs existenta.");
        saliDeClasa.add(room);
    }

    /**
     * Adaugarea unei sali de curs  in Array-ul dedicat cursurilor(saliDeCurs)
     * @param name numele salii
     * @param capacity capacitatea salii
     * @param videoProjector daca exista un video proiector in acea sala(este de tip boolean)
     */
    public void addEventHall(String name, int capacity,boolean videoProjector)
    {
        EventHall room=new EventHall(name,capacity,videoProjector);
        for(EventHall r:saliDeCurs)
            if(room.equals(r))
                System.out.println("Sala de clasa existenta.");
        saliDeCurs.add(room);
    }

    /**
     * Adaugarea unui eveniment(curs/seminar) in  in Array-ul dedicat evenimentelor(cursuriSiSeminarii)
     * @param name numele evenimentului (prima litera indica si tipul; c pentru curs si l pentru laborator)
     * @param participants cate persoane participa la acest eveniment
     */
    public void addEvent(String name,int participants,int oraStart)
    {
        Event event=new Event(name,participants,oraStart);
        for(Event e:cursuriSiSeminarii)
            if(event.equals(e))
                System.out.println("Eveniment deja existent.");
        cursuriSiSeminarii.add(event);
    }

    //Cautarile la afisarea oricarui eveniment se face in functie de nume

    /**
     * Afisare date despre un eveniment
     * @param numeEvent numele evenimentului pe care il cautam
     * @return returneaza datele cu ajutorul metodei toString() suprascrisa in clasa Event, sau mesajul "Nu exista"
     */
    public String afiseazaEvent(String numeEvent)
    {
        for (Event e : cursuriSiSeminarii)
            if (numeEvent.equals(e.getName())) {
                return e.toString();
            }
        return "Nu exista";
    }

    /**
     * Afiseaza date despre o incapere de tip laborator
     * @param numeRoom numele salii de laborator pe care o cautam
     * @return returneaza datele cu ajutorul metodei toString() suprascrisa in clasa Laboratory, sau mesajul "Nu exista"
     */
    public String afiseazaLaborator(String numeRoom)
    {
        for (Laboratory l : saliDeClasa)
            if (numeRoom.equals(l.getName())) {
                return l.toString();
            }
        return "Nu exista";
    }

    /**
     * Afiseaza date despre o incapere de tip sala de curs
     * @param numeRoom numele salii de curs pe care o cautam
     * @return returneaza datele cu ajutorul metodei toString() suprascrisa in clasa EventHall, sau mesajul "Nu exista"
     */
    public String afiseazaSalaDeCurs(String numeRoom)
    {
        for (EventHall e : saliDeCurs)
            if (numeRoom.equals(e.getName())) {
                return e.toString();
            }
        return "Nu exista";
    }



}