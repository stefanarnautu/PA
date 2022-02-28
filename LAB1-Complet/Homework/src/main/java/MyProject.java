import java.util.ArrayList;
import java.util.Random;

public class MyProject {

    public static ArrayList<String> words = new ArrayList<String>();
    public static int n,k;

    static boolean vecinatate(int x,int y)
    {
        String sir1=words.get(x);
        String sir2=words.get(y);

        for(int i=0;i<k;i++)
            for(int j=0;j<k;j++)
                if(sir1.charAt(i)==sir2.charAt(j))
                    return true;

        return false;
    }

    public static void main(String[] args)
    {

        String[] letters=new String[10];
        int lit=0;
        n=Integer.parseInt(args[0]);
        k=Integer.parseInt(args[1]);
        for(int i=0;i<args.length-2; i++) {
            letters[i] = args[i + 2];
            lit++;
        }

        String individ=new String();

        for(int i=0;i<n;i++)
        {
            individ="";
                Random rand = new Random();
                int r;
                for(int j=0;j<k;j++) {
                    r = rand.nextInt(lit);
                    individ+=letters[r];
                }
            words.add(individ);
        }

        boolean[][] vecini=new boolean[n][n];

        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++)
                if(vecinatate(i,j)==true)
                {
                    vecini[j][i]=vecini[i][j]=true;
                }
                else vecini[j][i]=vecini[i][j]=false;

        /*for(int i=0;i<n;i++){
            for (int j=0;j<n;j++)
            {
                if(!vecini[i][j])
                    System.out.print("f");
               else System.out.print("a");
            }
            System.out.println("");
        }*/

        String[][] neighbors= new String[n][n];
        String vecinNou=new String();
        for(int i=0;i<n;i++) {
           int numarVecini=0;
            for (int j = 0; j < n; j++) {
                if (vecini[i][j] == true) {
                    vecinNou = words.get(j);
                    neighbors[i][numarVecini] = vecinNou;
                    numarVecini++;
                }
            }
        }
        for(int i=0;i<n;i++) {
            System.out.println(i);
            int contor=0;
            while(neighbors[i][contor]!=null)
            {
                System.out.print(neighbors[i][contor]+" ");
                contor++;
            }
            System.out.println("");
        }
    }

}
