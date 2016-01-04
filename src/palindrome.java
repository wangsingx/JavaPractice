/**
 * Created by wangxing on 2015/12/18.
 */
public class palindrome {
    public static boolean isPalind1(String str) {
        int len = str.length();
        char[] cStr = str.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (cStr[i] != cStr[len - i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalind1("abcdcba"));
    }
}
