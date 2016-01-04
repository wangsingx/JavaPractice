import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by wangxing on 2015/12/19.
 */
public class CollectionTest {
    public static void iteratorTest() {
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("wangsingx");

        Iterator it = c.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        iteratorTest();
    }
}
