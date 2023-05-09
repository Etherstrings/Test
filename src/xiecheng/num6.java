package xiecheng;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-29 19:58 xiecheng - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num6 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/29 - the current system date.  19:58 - the current system time.  2023 - the current year.  03 - the current month.  29 - the current day of the month.  19 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num6 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        findMin(n);
    }
    public static void findMin(int n) {
        int min = Integer.MAX_VALUE;
        int minX = 0;
        int minY = 0;
        for (int x = 1; x <= n; x++) {
            if (x == 2) continue;
            for (int y = 1; y <= n; y++) {
                if (y == 2) continue;
                int temp = Math.abs(factorial(x) * y - y - n);
                if (temp < min) {
                    min = temp;
                    minX = x;
                    minY = y;
                }
            }
        }
        System.out.println(minX + " " + minY);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
