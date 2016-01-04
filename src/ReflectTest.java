import java.lang.reflect.*;

/**
 * Created by wangxing on 2015/12/20.
 */

public class ReflectTest {
    public static void test1() throws ClassNotFoundException {
        Person p1 = new Person();
        Class c1 = p1.getClass();

        Person p2 = new Person();
        Class c2 = p2.getClass();

        System.out.println(p1 == p2);
        System.out.println(c1 == c2);

        Class<Person> c3 = Person.class;
        System.out.println(c1 == c3);

        Class c4 = Class.forName("Person");
        System.out.println(c1 == c4);
    }

    public static void test2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class c = Class.forName("Person");
        Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println();

        cons = c.getConstructors();
        for (Constructor con :
                cons) {
            System.out.println(con);
        }
        System.out.println();

        Constructor con = c.getConstructor();
        System.out.println(con);
        System.out.println();

        Object o = con.newInstance();
        System.out.println(o);
        System.out.println();

        con = c.getConstructor(String.class, int.class, String.class);
        System.out.println(con);
        System.out.println(con.newInstance("wangsingx", 24, "chengdu"));
        System.out.println();

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field field = c.getField("address");
        System.out.println(field);
        field.set(o, "chongqing");
        System.out.println(o);
        System.out.println();

        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        Method method = c.getMethod("method", String.class);
        method.invoke(o, "hello");

    }

    public static void main(String[] args) {
        try {
            test2();
        } catch (NoSuchFieldException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    int age;
    public String address;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void show() {
        System.out.println("show");
    }

    public void method(String s) {
        System.out.println("method " + s);
    }

    public String getString(String s, int i) {
        return s + "---" + i;
    }

    private void function() {
        System.out.println("function");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address
                + "]";
    }

}
