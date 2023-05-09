package Tuyou;

import Mian.nums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-12 13:30 Tuyou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  13:30 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  13 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] nums=new int[n];
        String[] words=in.nextLine().split(" ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(words[i]);
        }
        char[] boo=in.nextLine().toCharArray();
        System.out.println(getans(nums,boo));
    }
    public static long getans(int[]nums,char[] boo){
        List<Integer> B=new ArrayList<>();
        List<Integer> R=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(boo[i]=='B'){
                B.add(nums[i]);
            }else {
                R.add(nums[i]);
            }
        }
        Collections.sort(B);
        Collections.sort(R);
        long a=B.get(0)*R.get(0);
        long b=B.get(0)*R.get(R.size()-1);
        long d=R.get(R.size()-1)*B.get(B.size()-1);

        return Math.max(Math.max(a,b),d);
    }

    public static long getans1(int[]nums,char[] boo){
        //b0 b的最小值
            int b0=Integer.MAX_VALUE;
        //b1 b的最大值
            int b1=Integer.MIN_VALUE;

        //r0 r的最小值
        int r0=Integer.MAX_VALUE;
        //r1 r的最大值
        int r1=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(boo[i]=='B'){
                b0=Math.min(b0,nums[i]);
                b1=Math.max(b1,nums[i]);
            }else {
                r0=Math.min(r0,nums[i]);
                r1=Math.max(r1,nums[i]);
            }
        }

        return Math.max(Math.max(b0*r0,b0*r1),Math.max(b1*r0,b1*r1));
    }
}
