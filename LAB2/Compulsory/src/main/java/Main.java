public class Main {
    public static void main(String[] args)
    {
     Event c1=new Event("c1",100,8,10,Type.lectureHall);
     Event c2=new Event("c2",100,10,12,Type.lectureHall);
     Event l1=new Event("l1",30,8,10,Type.lab);
     Event l2=new Event("l2",30,8,10,Type.lab);
     Event l3=new Event("l3",30,10,12,Type.lab);
     Room r309=new Room("r309",Type.lectureHall,100);
     Room r401=new Room("r401",Type.lab,30);
     Room r403=new Room("r403",Type.lab,30);
     Room r405=new Room("r405",Type.lab,30);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(r309);
        System.out.println(r401);
        System.out.println(r403);
        System.out.println(r405);
    }
}
