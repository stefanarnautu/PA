import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args){

        Network net=new Network();

        Computer computeA=new Computer("A","MAC","Tg.Neamt","20.30.40.54:2024");
        Router routerA=new Router("B","MAC","Tg.Neamt","11.45.32.40:2000");
        Switch switchA=new Switch("C","Tg.Neamt","23.54.71.45:2067");
        Computer computeB=new Computer("D","MAC","Tg.Neamt","20.30.40.54:2024");
        Router routerB=new Router("E","MAC","Tg.Neamt","11.45.32.40:2000");
        Switch switchB=new Switch("F","Tg.Neamt","23.54.71.45:2067");

        Computer computeC=new Computer("A1","MAC","Tg.Neamt","20.30.40.54:2024");
        Computer computeD=new Computer("A2","MAC","Tg.Neamt","20.30.40.54:2024");
        Computer computeE=new Computer("A3","MAC","Tg.Neamt","20.30.40.54:2024");

        net.addNodes(computeB);
        net.addNodes(routerB);
        net.addNodes(switchB);

        net.addNodes(computeC);
        net.addNodes(computeD);
        net.addNodes(computeE);

        net.addNodes(computeA);
        net.addNodes(routerA);
        net.addNodes(switchA);

        net.afiseazaObiectele();
        net.sorteaza();
        net.afiseazaObiectele();
    }
}
