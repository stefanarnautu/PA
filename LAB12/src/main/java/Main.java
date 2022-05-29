import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class myClass = null;
        try {
            myClass = Class.forName("classes.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Name:" + myClass.getName());
        System.out.println();
        System.out.println("Constructors:");
        Constructor[] constructors = myClass.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.toString());
        }
        System.out.println();
        System.out.println("Methods:");
        Method[] methods = myClass.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.toString());
        }
    }
}
