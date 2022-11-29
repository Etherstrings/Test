package tencent;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-16 21:09 tencent - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num5 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/16 - the current system date.  21:09 - the current system time.  2022 - the current year.  10 - the current month.  16 - the current day of the month.  21 - the current hour.  09 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num5 {
    public static void main(String[] args) {
        //从中间开始找xy
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        String line2[]=in.nextLine().split(" ");
        int[] nums=new int[line2.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int now=Integer.parseInt(line2[i]);
            sum+=now;
            nums[i]=now;
        }
        int a=sum/2;
        int b=sum-a;
        //每次有四种尝试
        //a -b  -a b
        while(a>=0){
            //当前的a b
            //a -b
            if(find(a,-b,nums)){

            }
            //-a b
            if(find(-a,b,nums)){

            }

            //结束后的a b
            a--;
            b++;
        }

    }

    static boolean find(int a,int b,int[] nums){
        return false;

    }
}
