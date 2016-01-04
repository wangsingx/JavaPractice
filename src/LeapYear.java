import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxing on 2015/12/16.
 */
public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 100 == 0 && year % 400 != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int year = 2015;
        List<Integer> leapYear = new ArrayList<>();
        for (int i = year; i < Integer.MAX_VALUE; i++) {
            if (isLeapYear(i))
                leapYear.add(i);
            if (leapYear.size() == 100)
                break;
        }
        for (int i :
                leapYear) {
            System.out.println(i);
        }
    }
}
