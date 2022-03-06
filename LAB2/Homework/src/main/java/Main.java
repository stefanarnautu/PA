public class Main {
    public static void main(String[] args)
    {
        //Primul punct din tema
        InstantaProblema problem=new InstantaProblema();

        //Populam instanta
        problem.addEvent("c1",100,8,10);
        problem.addEvent("c2",100,10,12);
        problem.addEvent("c3",100,16,18);
        problem.addEvent("c4",100,16,18);
        problem.addEvent("c5",100,8,10);
        problem.addEvent("c6",100,16,18);
        problem.addEvent("l1",30,8,10);
        problem.addEvent("l2",30,8,10);
        problem.addEvent("l3",30,10,12);
        problem.addEventHall("r309",100,true);
        problem.addEventHall("r310",100,true);
        problem.addEventHall("r311",100,false);
        problem.addLaboratory("r401",30);
        problem.addLaboratory("r403",30);
        problem.addLaboratory("r405",30);
        problem.addLaboratory("r405",30);

        //problem.addEvent("l3",30,10,12,Type.LAB);
       // System.out.println(problem.afiseazaEvent("l3"));
       // System.out.println(problem.afiseazaLaborator("r401"));
       // System.out.println(problem.afiseazaSalaDeCurs("r309"));
       // System.out.println(problem.saliDeCurs.get(0).getVideoProjector());

        //Solutia si afisarea "orarului"
        Solution solutiaProblemei=new Solution(problem);
        solutiaProblemei.afisearaOrar();
    }

}
