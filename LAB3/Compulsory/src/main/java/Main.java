public class Main {
    public static void main(String[] args){

        Network net=new Network();

        Computer computeA=new Computer("computerB","MAC","Tg.Neamt","20.30.40.54:2024");
        Router routerA=new Router("routerA","MAC","Tg.Neamt","11.45.32.40:2000");
        Switch switchA=new Switch("switchA","Tg.Neamt","23.54.71.45:2067");
        Computer computeB=new Computer("computerB","MAC","Tg.Neamt","20.30.40.54:2024");
        Router routerB=new Router("routerB","MAC","Tg.Neamt","11.45.32.40:2000");
        Switch switchB=new Switch("switchB","Tg.Neamt","23.54.71.45:2067");
        net.addNodes(computeA);
        net.addNodes(routerA);
        net.addNodes(switchA);
        net.addNodes(computeB);
        net.addNodes(routerB);
        net.addNodes(switchB);

        net.afiseazaObiectele();
    }
}
