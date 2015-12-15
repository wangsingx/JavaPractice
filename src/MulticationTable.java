/**
 * Created by wangxing on 2015/12/15.
 */
public class MulticationTable {
    public static void print1(int n) {
        if (n > 9 || n < 2) {
            System.out.println("valid input:(2-9)");
        } else {
            int i, j;
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= i; j++) {
                    System.out.print(i + "X" + j + "=" + i * j + " ");
                }
                System.out.println();
            }
        }
    }

    public static void print2(int n) {
        if (n > 9 || n < 2) {
            System.out.println("valid input:(2-9)");
        } else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.printf("%dX%d=%-2d ", i, j, i * j);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        print1(20);
        print2(9);
    }
}
