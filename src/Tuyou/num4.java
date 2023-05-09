package Tuyou;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-12 13:43 Tuyou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  13:43 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  13 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num4 {
    final static int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long[] dp=new long[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            if(i%2==0){
                dp[i]=(dp[i-1]+1)%MOD;
            }else {
                dp[i]=(dp[i-1]*2)%MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
