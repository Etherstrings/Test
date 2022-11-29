package tong58;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-22 19:38 tong58 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/22 - the current system date.  19:38 - the current system time.  2022 - the current year.  10 - the current month.  22 - the current day of the month.  19 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int N=Integer.parseInt(in.nextLine());
            String[] strs=in.nextLine().split(" ");
            int[] boxs=new int[strs.length];
            for(int i=0;i< strs.length;i++){
                boxs[i]=Integer.parseInt(strs[i]);
            }
            int sum=0;
            for(int num:boxs){
                sum+=num;
            }
            int ans=0;
            if(sum%2!=0){
                ans=0;
            }else {
                ans=sum/2;
            }
            System.out.println(ans);
        }
    }
}
