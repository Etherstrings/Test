package meituan;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-10 17:08 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/10 - the current system date.  17:08 - the current system time.  2022 - the current year.  09 - the current month.  10 - the current day of the month.  17 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meituan4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            String[] line2=in.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            int m= Integer.parseInt(line1[1]);
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=Integer.parseInt(line2[i]);
            }

            for(int i=0;i<nums.length;i++){
                nums[i]=get(nums[i],m);
            }
            for(int a:nums){
                System.out.print(a+" ");
            }
        }
    }

    static int get(int now,int m){
        int times=0;
        while(now%m!=0){
            if(now<m){
                int i=0;
                while(now<m){
                    now+=(int)Math.pow(10,i);
                    if(now>=m){
                        break;
                    }else {
                        now-=(int)Math.pow(10,i);
                        i++;
                    }
                }
                //此时now已经更新
                times++;
            }else if(now>m){
                now+=1;
                times++;
            }else {
                break;
            }
        }
        return times;
    }
}
