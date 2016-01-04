import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangxing on 2015/12/19.
 */
public class ListTest {
    public static void arrayTest() {
        List l1 = new ArrayList();
        l1.add("Hello");
        l1.add("world");
        l1.add("wangsingx");

        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }

        Iterator it = l1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public static void linkTest() {
        List l1 = new LinkedList();
        l1.add("Hello");
        l1.add(0, "world");
        l1.add("wangsingx");
        l1.remove(2);

        Iterator it = l1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public static void genericTest() {
        List<String> l1 = new ArrayList<String>();
        l1.add("Hello");
        l1.add("world");
        l1.add("wangsingx");

        for (String s :
                l1) {
            System.out.println(s);
        }
    }

    public static int maxValue(List<Integer> l) {
        int max = Integer.MIN_VALUE;
        for (int value : l) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public static List combineList(List l1, List l2) {
        List newList = new ArrayList();
        int l1Len = l1.size();
        int l2Len = l2.size();
        Iterator it1 = l1.iterator();
        Iterator it2 = l2.iterator();

        while (it1.hasNext()) {
            newList.add(it1.next());
            if (it2.hasNext()) {
                newList.add(it2.next());
            }
        }

        while (it2.hasNext()) {
            newList.add(it2.next());
        }

        Iterator it3 = newList.iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
        return newList;
    }

    public static void main(String[] args) {
//        arrayTest();
//        linkTest();
//        genericTest();
/*
        List<Integer> l = new ArrayList<Integer>();
        l.add(5);
        l.add(9);
        l.add(34);
        l.add(-2);
        System.out.println(maxValue(l));
*/
        List l1 = new ArrayList<Integer>();
        l1.add(5);
        l1.add(9);
        l1.add(34);
        l1.add(-2);

        List l2 = new ArrayList<Integer>();
        l2.add(567);
        l2.add(33);
        l2.add(98);
        l2.add(90);

        combineList(l1, l2);
    }
}
