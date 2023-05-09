package tong58;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-11 0:27 tong58 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num5 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/11 - the current system date.  0:27 - the current system time.  2023 - the current year.  03 - the current month.  11 - the current day of the month.  00 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(getans(n));
    }

    public static long getans(int n){
        if(n==1){
            return 2;
        }
        if(n==2){
            return 3;
        }
        long[] dp=new long[n+1];
        dp[1]=2;
        dp[2]=3;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
