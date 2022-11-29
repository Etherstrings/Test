package ali;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-22 9:58 ali - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  moni3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  9:58 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  09 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class moni3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[][] grid=new int[n][n];
        //从1--n
        boolean[] used=new boolean[n*n+1];
        System.out.println(-1);

    }

    static void Backtarcking(int level,int col,int[][] grid,boolean[] used){
        if(level==grid.length-1&&col== grid.length){
            //如果最后了
            return;
        }
        int n=grid.length;

    }
}
