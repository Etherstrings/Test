package yuque;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-15 15:53 yuque - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/15 - the current system date.  15:53 - the current system time.  2022 - the current year.  10 - the current month.  15 - the current day of the month.  15 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] nums= in.nextLine().split(" ");
            //
            int a=Integer.parseInt(nums[0]);
            int h=Integer.parseInt(nums[1]);
            //
            int b=Integer.parseInt(nums[2]);
            int k=Integer.parseInt(nums[3]);
            //
            int damage=0;
            while((h!=0&&k!=0)){
                //这俩都没死的时候
                damage+=round(a,h,b,k);
                //小红攻击
                //同时让这两个互相攻击
                //a先攻击b
                k=k-a;
                h=h-b;
                if(k<=0){
                    k=0;
                }
                if(h<=0){
                    h=0;
                }
                if(k==0||h==0){
                    damage+=round(a,h,b,k);
                }
            }
            System.out.println(damage);
        }
    }

    public static int round(int a,int h,int b,int k){
        if(h==0&&k==0){
            return 0;
        }
        if(h==0&&k!=0){
            return 10*b;
        }
        if(h!=0&&k==0){
            return 10*a;
        }
        return a+b;
    }
}
