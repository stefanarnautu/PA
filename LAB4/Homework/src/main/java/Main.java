import com.github.javafaker.Faker;

import java.util.*;

public class Main {
    public static void main(String[] args){

        Faker faker=new Faker();

        Intersection intersection1=new Intersection(faker.address().lastName());
        Intersection intersection2=new Intersection(faker.address().lastName());
        Intersection intersection3=new Intersection(faker.address().lastName());
        Intersection intersection4=new Intersection(faker.address().lastName());
        Intersection intersection5=new Intersection(faker.address().lastName());
        Intersection intersection6=new Intersection(faker.address().lastName());
        Intersection intersection7=new Intersection(faker.address().lastName());
        Intersection intersection8=new Intersection(faker.address().lastName());
        Intersection intersection9=new Intersection(faker.address().lastName());

        Street streetA=new Street(faker.address().streetName(),3,intersection1,intersection2,1,2);
        Street streetB=new Street(faker.address().streetName(),2,intersection1,intersection5,1,5);
        Street streetC=new Street(faker.address().streetName(),2,intersection1,intersection4,1,4);
        Street streetD=new Street(faker.address().streetName(),1,intersection2,intersection7,2,7);
        Street streetE=new Street(faker.address().streetName(),1,intersection2,intersection3,2,3);
        Street streetF=new Street(faker.address().streetName(),1,intersection3,intersection8,3,8);
        Street streetG=new Street(faker.address().streetName(),2,intersection2,intersection8,2,8);
        Street streetH=new Street(faker.address().streetName(),1,intersection3,intersection6,3,6);
        Street streetI=new Street(faker.address().streetName(),2,intersection6,intersection8,6,8);
        Street streetJ=new Street(faker.address().streetName(),2,intersection4,intersection5,4,5);
        Street streetK=new Street(faker.address().streetName(),2,intersection4,intersection9,4,9);
        Street streetL=new Street(faker.address().streetName(),1,intersection5,intersection9,5,9);
        Street streetM=new Street(faker.address().streetName(),3,intersection7,intersection9,7,9);
        Street streetN=new Street(faker.address().streetName(),2,intersection5,intersection7,5,7);
        Street streetO=new Street(faker.address().streetName(),3,intersection7,intersection8,7,8);

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
        strazi.add(streetO);
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
        City orasul=new City(strazi,intersectii);

        orasul.streetsLongerThan(2);

        Kruskal graph = new Kruskal(intersectii.size()+1, strazi.size());
        int contor=0;
        for(Street str:strazi) {
            graph.edge[contor].src =str.intersectia1;
            graph.edge[contor].dest = str.intersectia2;
            graph.edge[contor].weight = str.getLength();
            contor++;
           }
        graph.KruskalMST();
    }
}
