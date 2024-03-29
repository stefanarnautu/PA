import java.util.*;

public class Main {
    public static void main(String[] args){
        Intersection intersection1=new Intersection("Intersectia1");
        Intersection intersection2=new Intersection("Intersectia2");
        Intersection intersection3=new Intersection("Intersectia3");
        Intersection intersection4=new Intersection("Intersectia4");
        Intersection intersection5=new Intersection("Intersectia5");
        Intersection intersection6=new Intersection("Intersectia6");
        Intersection intersection7=new Intersection("Intersectia7");
        Intersection intersection8=new Intersection("Intersectia8");
        Intersection intersection9=new Intersection("Intersectia9");

        Street streetA=new Street("a",3,intersection1,intersection2);
        Street streetB=new Street("b",2,intersection1,intersection5);
        Street streetC=new Street("c",2,intersection1,intersection4);
        Street streetD=new Street("d",1,intersection2,intersection7);
        Street streetE=new Street("e",1,intersection2,intersection3);
        Street streetF=new Street("f",1,intersection3,intersection8);
        Street streetG=new Street("g",2,intersection2,intersection8);
        Street streetH=new Street("h",1,intersection3,intersection6);
        Street streetI=new Street("i",2,intersection6,intersection8);
        Street streetJ=new Street("j",2,intersection4,intersection5);
        Street streetK=new Street("k",2,intersection4,intersection9);
        Street streetL=new Street("l",3,intersection7,intersection9);
        Street streetM=new Street("m",2,intersection5,intersection7);
        Street streetN=new Street("n",3,intersection7,intersection8);

        List<Street> strazi=new LinkedList<>();
        strazi.add(streetA);
        strazi.add(streetB);
        strazi.add(streetC);
        strazi.add(streetD);
        strazi.add(streetE);
        strazi.add(streetF);
        strazi.add(streetG);
        strazi.add(streetH);
        strazi.add(streetI);
        strazi.add(streetJ);
        strazi.add(streetK);
        strazi.add(streetL);
        strazi.add(streetM);
        strazi.add(streetN);
        Collections.sort(strazi,(a,b)->Street.compareByLength(a,b));

        for(Street s: strazi){
            System.out.println(s.toString());
        }
        Set<Intersection> intersectii=new HashSet<>();
        intersectii.add(intersection1);
        intersectii.add(intersection2);
        intersectii.add(intersection3);
        intersectii.add(intersection4);
        intersectii.add(intersection5);
        intersectii.add(intersection6);
        intersectii.add(intersection7);
        intersectii.add(intersection8);
        intersectii.add(intersection9);

        for(Intersection i:intersectii){
            System.out.println(i);
        }


    }
}
