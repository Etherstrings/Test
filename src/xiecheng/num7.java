package xiecheng;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-29 20:11 xiecheng - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num7 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/29 - the current system date.  20:11 - the current system time.  2023 - the current year.  03 - the current month.  29 - the current day of the month.  20 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num7 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] Tu=new int[n][3];
        for(int i=1;i<n;i++){
            int start=in.nextInt();
            int end=in.nextInt();
            int value=in.nextInt();
            Tu[i]=new int[]{start,end,value};
        }

    }
}
