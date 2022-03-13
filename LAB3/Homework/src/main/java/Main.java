import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args){

        Network net=new Network();

        Computer computeA=new Computer("v1","MAC","Tg.Neamt","20.30.40.54:2024",4);
        Router routerA=new Router("v2","MAC","P.Neamt","11.45.32.40:2000");
        Switch switchA=new Switch("v3","Timisoara","23.54.71.45:2067");
        Computer computeB=new Computer("v6","MAC","Iasi","20.30.40.54:2024",8);
        Router routerB=new Router("v5","MAC","Bucuresti","11.45.32.40:2000");
        Switch switchB=new Switch("v4","Arad","23.54.71.45:2067");

        Computer computeC=new Computer("v8","MAC","Bacau","20.30.40.54:2024",16);
        Computer computeD=new Computer("v7","MAC","Arad","20.30.40.54:2024",20);
        Computer computeE=new Computer("v9","MAC","Cluj","20.30.40.54:2024",12);
        net.addNodes(computeC);
        net.addNodes(computeD);
        net.addNodes(computeE);

        net.addNodes(computeA);
        net.addNodes(routerA);
        net.addNodes(switchA);
        net.addNodes(computeB);
        net.addNodes(routerB);
        net.addNodes(switchB);

        net.addCosts("v1","v2",10);
        net.addCosts("v1","v3",50);
        net.addCosts("v2","v3",20);
        net.addCosts("v2","v4",20);
        net.addCosts("v2","v5",10);
        net.addCosts("v3","v4",20);
        net.addCosts("v4","v5",30);
        net.addCosts("v4","v6",10);
        net.addCosts("v5","v6",20);

        //Inainte de sortare dupa nume
       // net.afiseazaObiectele();
        net.sorteaza();

        //System.out.println("");
        //Dupa sortare dupa nume
        net.afiseazaObiectele();

        //net.afiseazaCosturi();
       // computeA.printDifferent();
        net.afisareIdentifiable();
        net.sortareIdentifiable();
        System.out.println("");
        //Dupa sortare dupa nume
        net.afisareIdentifiable();

    }
}
