import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
     Event c1=new Event("c1",100,8,10,Type.lectureHall);
     Event c2=new Event("c2",100,10,12,Type.lectureHall);
     Event c3=new Event("c3",100,16,18,Type.lectureHall);
     Event l1=new Event("l1",30,8,10,Type.lab);
     Event l2=new Event("l2",30,8,10,Type.lab);
     Event l3=new Event("l3",30,10,12,Type.lab);
     Room r309=new Room("r309",Type.lectureHall,100);
     Room r401=new Room("r401",Type.lab,30);
     Room r403=new Room("r403",Type.lab,30);
     Room r405=new Room("r405",Type.lab,30);

     ArrayList<Room> saliDeClasa=new ArrayList<Room>();
     saliDeClasa.add(r309);
     saliDeClasa.add(r401);
     saliDeClasa.add(r403);
     saliDeClasa.add(r405);

     ArrayList<Event> cursuriSiSeminarii=new ArrayList<Event>();
     cursuriSiSeminarii.add(c1);
     cursuriSiSeminarii.add(c2);
     cursuriSiSeminarii.add(c3);
     cursuriSiSeminarii.add(l1);
     cursuriSiSeminarii.add(l2);
     cursuriSiSeminarii.add(l3);

        System.out.println(c1);
      //  System.out.println(c2);
      //  System.out.println(l1);
      //  System.out.println(l2);
      //  System.out.println(l3);
        System.out.println(r309);
      //  System.out.println(r401);
      //  System.out.println(r403);
      //  System.out.println(r405);

        //Intr-o sala se pot tine 6 cursuri/seminarii intr-o zi, de aceea fac un String[][] ca si orar al salilor
        //am zis ca sunt maxim 10 sali si fiecare sala poate time maxim 6 cursuri intr-o zi

        String[][] orarSali=new String[10][6];
        int nrCursDinZi=0,contor;
        for(Event ev:cursuriSiSeminarii)
        {
            nrCursDinZi=ev.getStartTime();
            nrCursDinZi-=8;
            nrCursDinZi/=2;
            //daca cursul este de la 8 va fi 0, daca este de la 10 va fi 1 ...
         contor=0;
            for (Room ro:saliDeClasa)
            {
                if(orarSali[contor][nrCursDinZi]==null) {
                    orarSali[contor][nrCursDinZi] = ev.getName();
                    break;
                }
                contor++;
            }
        }

        for(int i=0;i<4;i++) {
           // System.out.println(saliDeClasa.getName());
            for (int j = 0; j < 6; j++)
                System.out.print(orarSali[i][j]+ " ");
            System.out.println("");
        }
    }

}
