package Leetcode.week333;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-02-19 10:47 Leetcode.week333 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/19 - the current system date.  10:47 - the current system time.  2023 - the current year.  02 - the current month.  19 - the current day of the month.  10 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        System.out.println(minOperations1(54));
    }
    public int minOperations(int n) {
        //每一步使得采用更小的变换
        //接近某一个幂
        int ans=0;
        //每一步都选择最小的
        return 0;
    }

    public static int minOperations1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int j = 0;
            while (Math.pow(2, j) <= i) {
                dp[i] = Math.min(dp[i], dp[i - (int)Math.pow(2, j)] + 1);
                j++;
            }
        }
        return dp[n];
    }
}
