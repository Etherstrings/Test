package Gumi;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-25 14:44 Gumi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  nums1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/25 - the current system date.  14:44 - the current system time.  2023 - the current year.  03 - the current month.  25 - the current day of the month.  14 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class nums1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        Flag=false;
        Bucket=new int[]{0,0};
        backtarcking(0,nums);
        System.out.println(Flag);
    }
    public static int[] Bucket;
    public static boolean Flag;
    //回溯
    public static void backtarcking(int index,int[] nums){
        if(Flag=true){
            return;
        }
        if(index==nums.length){
            if(Bucket[0]==Bucket[1]){
                Flag=true;
            }
            return;
        }
        for(int i=index;i<nums.length;i++){
            Bucket[0]+=nums[i];
            backtarcking(i+1,nums);
            Bucket[0]-=nums[i];

            Bucket[1]+=nums[i];
            backtarcking(i+1,nums);
            Bucket[1]-=nums[i];
        }
    }
}
