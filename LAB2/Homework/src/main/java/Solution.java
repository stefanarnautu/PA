import java.util.Objects;

public class Solution {

    String[][] orarSali; //nu sunt sigur daca trebuie initializat aici

    public Solution(InstantaProblema problem) {

        //initializam orarul cu cate o linie pentru fiecare sala de curs/seminar si maxim 6 cursuri/seminarii pe zi
        orarSali = new String[problem.saliDeCurs.size()+problem.saliDeClasa.size()][6];

        //Luam fiecare eveniment si ii cautam un loc in orar
        //Cursurile vor fi puse doar in sali de curs iar seminariile vor fi puse doar in laboratoare

        int nrCursDinZi = 0;
        for(Event ev:problem.cursuriSiSeminarii)
        {
            nrCursDinZi=ev.getStartTime();
            nrCursDinZi-=8;
            nrCursDinZi/=2;
            //daca cursul este de la 8 va fi 0, daca este de la 10 va fi 1 ...

            if(ev.getName().charAt(0) == 'c')
            {
                for(int i=0;i<problem.saliDeCurs.size();i++)
                {
                    if(Objects.equals(orarSali[i][nrCursDinZi],null))
                    {
                        orarSali[i][nrCursDinZi]=ev.getName();
                        System.out.println(ev.getName().toUpperCase()+" -> "+problem.saliDeCurs.get(i).getName());
                        break;
                    }
                }
            }
            if(ev.getName().charAt(0) == 'l')
            {
                for(int i=problem.saliDeCurs.size();i<problem.saliDeCurs.size()+problem.saliDeClasa.size();i++)
                {
                    if(Objects.equals(orarSali[i][nrCursDinZi],null))
                    {
                        orarSali[i][nrCursDinZi]=ev.getName();
                        System.out.println(ev.getName().toUpperCase()+" -> "+problem.saliDeClasa.get(i-problem.saliDeCurs.size()).getName());
                        break;
                    }
                }
            }
        }
    }

    public void afisearaOrar(){
        for(int i=0;i<orarSali.length;i++) {
            for (int j = 0; j < 6; j++)
               if(Objects.equals(orarSali[i][j],null))
                   System.out.print("__ ");
               else
                    System.out.print(orarSali[i][j]+ " ");
            System.out.println("");
        }
    }

}
