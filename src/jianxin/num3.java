package jianxin;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-03-04 16:54 jianxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/4 - the current system date.  16:54 - the current system time.  2023 - the current year.  03 - the current month.  04 - the current day of the month.  16 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static int minWorkTime(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int aindex=A.length-1;
        int Bindex=0;
        int workTime=0;

        while(aindex>=0&&Bindex!=B.length){
            //贪心 先放A的
            //先放B 再放A
            
        }



        return workTime;
    }
}
