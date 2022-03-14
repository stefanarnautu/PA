public class Main {
    public static void main(String[] args){

        Network net=new Network();

        Computer computeA=new Computer("v1","AX-10-44-00-HD-HD","Tg.Neamt","20.30.40.54:2024",4);
        Router routerA=new Router("v2","UA-03-28-00-AD-YD","P.Neamt","11.45.32.40:2000");
        Switch switchA=new Switch("v3","GH-03-28-00-AD-YD","Brasov");
        Computer computeB=new Computer("v6","JK-67-94-00-XX-TX","Iasi","20.30.40.54:2024",8);
        Router routerB=new Router("v5","DY-22-91-00-XX-AG","Bucuresti","11.45.32.40:2000");
        Switch switchB=new Switch("v4","HS-57-25-00-XX-JV","Ilfov");

       /* Computer computeC=new Computer("v8","HS-57-25-12-XX-JV","Bacau","22.30.40.54:2024",16);
        Computer computeD=new Computer("v7","HS-57-25-FH-XX-JV","Arad","20.32.40.54:2024",20);
        Computer computeE=new Computer("v9","HS-57-25-CG-XX-JV","Cluj","20.36.40.54:2024",12);
        net.addNodes(computeC);
        net.addNodes(computeD);
        net.addNodes(computeE);*/

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

        net.sorteaza();
        net.afiseazaObiectele();
        System.out.println(" ");
        net.afiseazaCosturi();
        System.out.println(" ");
        computeA.printDifferent();
        System.out.println(" ");
        net.dijkstra(switchB);
        System.out.println(" ");
        net.afisareSortareIdentifiable();
    }
}
