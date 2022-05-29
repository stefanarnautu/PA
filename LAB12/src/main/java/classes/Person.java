package classes;

import org.testng.annotations.Test;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){
        this.name = "";
        this.age = -1;
    }

    public String getName() {
        return name;
    }

    @Test
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Test
    public void setAge(int age) {
        if(age<=110 && age>=0)
            this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
