import polymorphism.Circle;
import polymorphism.Shape;
import polymorphism.Square;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        List<Shape> list = Arrays.asList(new Circle(),new Square());
        list.forEach(System.out::println);


        Class clazz = Class.forName("polymorphism.Square");
        printInfo(clazz);
        printClassInnerStructure(clazz);
        magic(clazz);

    }


    public static void printInfo(Class clazz) {
        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getName()).append("\n")
            .append(clazz.isInterface()).append("\n")
            .append(clazz.getSimpleName()).append("\n")
            .append(clazz.getCanonicalName()).append("\n")
            .append(Arrays.toString(clazz.getInterfaces())).append("\n")
            .append(clazz.getSuperclass())
            .append(Arrays.toString(clazz.getAnnotations()));
        System.out.println(sb);
    }

    public static void printClassInnerStructure(Class clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        StringBuilder sb = new StringBuilder();
        sb.append("Methods")
          .append(Arrays.toString(clazz.getMethods()))
          .append("\nFields")
          .append(Arrays.toString(clazz.getFields()))
          .append("\nConstructors")
          .append(Arrays.toString(clazz.getConstructors()));
        System.out.println(sb);
    }

    public static void magic(Class clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor c = clazz.getConstructor();
        Object o = c.newInstance();
//        System.out.println(o.getClass());
        Field f = Arrays.stream(o.getClass().getDeclaredFields())
                .filter(field -> field.getName().contains("txt"))
                .findFirst().get();
        f.setAccessible(true);
        f.set(o, "tratatatatat");


        Method m = clazz.getMethods()[0];
                Arrays.stream(clazz.getMethods()).filter(method -> method.getName().contains("printF")).findFirst().get();
        Object[] arr = {"pref", 6};
        m.invoke(o, arr);
    }
}
