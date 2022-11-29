package XIaomi;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-20 19:21 XIaomi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  xiaomi2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/20 - the current system date.  19:21 - the current system time.  2022 - the current year.  09 - the current month.  20 - the current day of the month.  19 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class xiaomi2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str1=in.nextLine();
            String str2=in.nextLine();
            str1=str1.substring(1,str1.length()-1);
            str2=str2.substring(1,str2.length()-1);
            int[][] dp=new int[str1.length()][str2.length()];

            for(int i=1;i<str1.length();i++){
                dp[i][0]=i;
            }
            for(int i=1;i<str2.length();i++){
                dp[0][i]=i;
            }
            for(int i=1;i<str1.length();i++){
                for(int j=1;j<str2.length();j++){
                    if(str1.charAt(i)==str2.charAt(j)){
                        dp[i][j]=dp[i-1][j-1];
                    }else {
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    }
                }
            }
            System.out.println(dp[str1.length()-1][str2.length()-1]);
        }
    }
}
