import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {

        InstantaProblema problem=new InstantaProblema();

        problem.addEvent("c1",100,8,10,Type.LECTUREHALL);
        problem.addEvent("c2",100,10,12,Type.LECTUREHALL);
        problem.addEvent("c3",100,16,18,Type.LECTUREHALL);
        problem.addEvent("l1",30,8,10,Type.LAB);
        problem.addEvent("l2",30,8,10,Type.LAB);
        problem.addEvent("l3",30,10,12,Type.LAB);
        problem.addRoom("r309",Type.LECTUREHALL,100);
        problem.addRoom("r401",Type.LAB,30);
        problem.addRoom("r403",Type.LAB,30);
        problem.addRoom("r405",Type.LAB,30);

        //problem.addEvent("l3",30,10,12,Type.LAB);

        System.out.println(problem.afiseazaEvent("l3"));
        System.out.println(problem.afiseazaRoom("r309"));
        System.out.println(problem.afiseazaRoom("l3"));

        //Intr-o sala se pot tine 6 cursuri/seminarii intr-o zi, de aceea fac un String[][] ca si orar al salilor
        //am zis ca sunt maxim 10 sali si fiecare sala poate time maxim 6 cursuri intr-o zi

     //   String[][] orarSali=new String[10][6];
        int nrCursDinZi=0,contor;
   /*     for(Event ev:cursuriSiSeminarii)
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
       //         System.out.print(orarSali[i][j]+ " ");
            System.out.println("");
        }*/
    }

}
