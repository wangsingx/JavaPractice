import java.math.BigDecimal;

/**
 * Created by wangxing on 2015/12/20.
 */
public class FibTest {
    public static void test1() {
        int n = 50;
        BigDecimal[] fib = new BigDecimal[n];
        fib[0] = new BigDecimal(1);
        fib[1] = new BigDecimal(1);
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(fib[i]);
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
