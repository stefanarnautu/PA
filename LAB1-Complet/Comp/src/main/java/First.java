public class First {
    static int calcul(int numar)
    {
        int sum=0;
        while(numar>0) {
            sum +=numar%10;
            numar=numar/10;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println("Hello World");
        String[] languages={"C","C++","C#","Python","Go","Rust","JavaScript","PHP","Swift","Java"};
        int n = (int) (Math.random() * 1_000_000);
        n*=3;
        String binar="10101",binar2="FF";
        n+=Integer.parseInt(binar,2);
        n+=Integer.parseInt(binar2,16);
        n*=6;

        System.out.println(n);

        int valoare=calcul(n);
        while(valoare/10>0)
        {
            valoare=calcul(valoare);
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[valoare]);
    }

}
