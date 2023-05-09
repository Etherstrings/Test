package jianxin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-04 15:49 jianxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/4 - the current system date.  15:49 - the current system time.  2023 - the current year.  03 - the current month.  04 - the current day of the month.  15 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int N=Integer.parseInt(in.nextLine().trim());
            Long[][] coups=new Long[N][2];
            for(int i=0;i<N;i++){
                String[] temp=in.nextLine().split(" ");
                coups[i][0]=Long.parseLong(temp[0]);
                coups[i][1]=Long.parseLong(temp[1]);
            }
            System.out.println(getans(coups));
        }
    }

    public static String getans(Long[][] coups){
        String ans="";
        for(Long[] now:coups){
            long min=smallestNumber(now[0]);
            if(min==now[1]){
                ans+="1";
            }else {
                ans+="0";
            }

        }
        return ans;
    }

    public static long smallestNumber(long num) {
        long[] count = new long[10];
        long ans = 0;

        for (long i = Math.abs(num); i != 0; i /= 10) {
            count[(int)Math.abs(i % 10)]++;
        }

        if (num > 0) {
            for (int i = 1; i <= 9; i++) {
                while (count[i]-- > 0) {
                    ans = ans * 10 + i;
                    while (count[0]-- > 0) {
                        ans = ans * 10 + 0;
                    }
                }
            }
        } else {
            for (int i = 9; i >= 0; i--) {
                while (count[i]-- > 0) {
                    ans = ans * 10 + i;
                }
            }
        }
        return num > 0 ? ans : -ans;
    }


}
