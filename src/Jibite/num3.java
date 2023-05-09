package Jibite;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-12 15:13 Jibite - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  15:13 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  15 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        String[] words=in.nextLine().split(" ");
        for(int i=0;i<words.length;i++){
            nums[i]=Integer.parseInt(words[i]);
        }

    }
}
