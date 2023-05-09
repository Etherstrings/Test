package Leetcode.week337;

/**
 * @author Etherstrings
 * @create 2023-03-19 10:24 Leetcode.week337 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  10:24 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  10 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {

    }

    public int[] evenOddBit(int n) {
        int[] answer = new int[2];
        int even = 0, odd = 0;
        for (int i = 0; i <= 31; i++) {
            int bit = (n >> i) & 1;
            if (i % 2 == 0 && bit == 1) {
                even++;
            } else if (i % 2 == 1 && bit == 1) {
                odd++;
            }
        }
        answer[0] = even;
        answer[1] = odd;
        return answer;
    }
}
