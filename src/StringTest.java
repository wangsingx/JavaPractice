/**
 * Created by wangxing on 2015/12/19.
 */
public class StringTest {
    public static void printString(String str) {
        str = str.replace(',', ' ');
        str = str.replace('.', ' ');
        String[] pStr = str.split(" ");
        int lines = pStr.length;
        int[] len = new int[lines];
        int column = 0;
        for (int i = 0; i < lines; i++) {
            len[i] = pStr[i].length();
            column = column > len[i] ? column : len[i];
        }
        StringBuffer stars = new StringBuffer("");
        for (int i = 0; i < column + 4; i++) {
            stars.append("*");
        }
        System.out.println(stars);
        for (int i = 0; i < lines; i++) {
            System.out.print("* ");
            System.out.print(pStr[i]);
            for (int j = pStr[i].length(); j < column; j++) {
                System.out.print(" ");
            }
            System.out.println(" *");
        }
        System.out.println(stars);
    }

    public static void pigLatin(String str) {
        str = str.replace(',', ' ');
        str = str.replace('.', ' ');
        str = str.toLowerCase();
        String[] pStr = str.split(" ");
        for (int i = 0; i < pStr.length; i++) {
            pStr[i] = pStr[i].concat(pStr[i].substring(0, 1)).concat("ay");
            pStr[i] = pStr[i].substring(1, pStr[i].length());
            System.out.print(pStr[i] + " ");
        }
    }

    public static void main(String[] args) {
        printString("Hello world,in a frame");
        pigLatin("The quick brown fox");
    }
}
