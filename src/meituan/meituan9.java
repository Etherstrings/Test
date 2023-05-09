package meituan;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-18 11:26 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan9 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  11:26 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  11 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class meituan9 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        String[] words=in.nextLine().split(" ");
        int[] nums=new int[N];
        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(words[i]);
        }
        int[][] temp=new int[N-1][2];
        for(int i=0;i<temp.length;i++){
            String[] word=in.nextLine().split(" ");
            int[] t=new int[2];
            t[0]=Integer.parseInt(word[0]);
            t[1]=Integer.parseInt(word[1]);
            temp[i]=t;
        }

    }
}
