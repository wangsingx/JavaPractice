import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxing on 2015/12/15.
 */
public class PrimeNumber {
    public static void list1(List<Integer> primeNO, int Nmax) {
        int size, tmp;
        for (int i = 21; i < Nmax; i += 2) {
            size = primeNO.size();
            for (int j = 0; j < size; j++) {
                tmp = primeNO.get(j);
                if (i / 2 < tmp) {
                    primeNO.add(i);
                    break;
                }
                if (i % tmp == 0) {
                    break;
                }

                if (j == size - 1) {
                    primeNO.add(i);
                }
            }
        }
    }

    public static void list2(int Nmax) {
        boolean[] isPrime = new boolean[Nmax + 1];
        for (int i = 3; i <= Nmax; i += 2)
            isPrime[i] = true;
        isPrime[2] = true;
        for (int i = 3; i <= Math.sqrt(Nmax); i += 2) {
            if (isPrime[i] == true) {
                for (int j = i * i; j <= Nmax; j += 2 * i)
                    isPrime[j] = false;
            }
        }
        int primeNum = 0;
        for (int i = 1; i <= Nmax; i++) {
            if (isPrime[i] == true)
                primeNum++;
        }
        System.out.println(primeNum);
    }

    public static void list3(int Nmax) {
        boolean[] isPrime = new boolean[Nmax + 1];
        for (int i = 3; i <= Nmax; i += 2)
            isPrime[i] = true;
        isPrime[2] = true;
        for (int i = 2; i <= Math.sqrt(Nmax); i++) {
            if (isPrime[i] == true) {
                for (int j = 2; j <= Nmax / i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        int primeNum = 0;
        for (int i = 1; i <= Nmax; i++) {
            if (isPrime[i] == true)
                primeNum++;
        }
        System.out.println(primeNum);
    }

    public static void main(String[] args) {
        List<Integer> primeNO = new ArrayList<Integer>();
        primeNO.add(2);
        primeNO.add(3);
        primeNO.add(5);
        primeNO.add(7);
        primeNO.add(11);
        primeNO.add(13);
        primeNO.add(17);
        primeNO.add(19);

        long start = System.currentTimeMillis();
        list2(20000000);
        long time = System.currentTimeMillis() - start;
        System.out.println("运行耗时= " + time + " 毫秒");
        start = System.currentTimeMillis();
        list3(20000000);
        time = System.currentTimeMillis() - start;
        System.out.println("运行耗时= " + time + " 毫秒");
        /*
        for (int i : primeNO) {
            System.out.println(i);
        }
        */

    }
}
