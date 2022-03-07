public class Main {
    public static void main(String[] args){

        Network net=new Network();

        Computer computeA=new Computer("Computer A","MAC","Tg.Neamt","20.30.40.54:2024");
        Router routerA=new Router("routerA","MAC","Tg.Neamt","11.45.32.40:2000");
        Switch switchA=new Switch("switchA","Tg.Neamt","23.54.71.45:2067");
        net.addNodes(computeA);
        net.addNodes(routerA);
        net.addNodes(switchA);

        net.afiseazaObiectele();
    }
}
