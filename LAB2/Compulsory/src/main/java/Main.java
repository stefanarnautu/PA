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
        problem.addEventHall("r309",Type.LECTUREHALL,100,true);
        problem.addLaboratory("r401",Type.LAB,30);
        problem.addLaboratory("r403",Type.LAB,30);
        problem.addLaboratory("r405",Type.LAB,30);

        //problem.addEvent("l3",30,10,12,Type.LAB);

        System.out.println(problem.afiseazaEvent("l3"));
        System.out.println(problem.afiseazaLaborator("r401"));
        System.out.println(problem.afiseazaSalaDeCurs("r309"));

        System.out.println(problem.saliDeCurs.get(0).getVideoProjector());

    }

}
