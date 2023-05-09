package Leetcode.week337;

import Mian.nums;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-19 11:14 Leetcode.week337 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  11:14 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  11 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        //        System.out.println(beautifulSubsets(new int[]{2,4,6},2));
        //        System.out.println(beautifulSubsets(new int[]{1},1))

        System.out.println(beautifulSubsets(new int[]{4,2,5,9,10,3},1));
    }
    public static int beautifulSubsets1(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(nums[i]);
            sum++;
            for(int j=i+1;j<nums.length;j++){
                int now=nums[j];
                boolean canuse=true;
                for(int n:temp){
                    if(Math.abs(now-n)==k){
                        canuse=false;
                        break;
                    }
                }
                if(canuse){
                    temp.add(nums[j]);
                    sum++;
                }else {
                    continue;
                }
            }
        }
        return sum;
    }
    //非空且任意两个整数的差值不小于k
    public static int beautifulSubsets(int[] nums, int k){
        sum=0;
        back(0,nums,k);
        return sum;
    }
    public static LinkedList<Integer> Path=new LinkedList<>();

    public static int sum;

    public static void back(int index,int[] nums, int k){
        if(index==nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(Path.size()==0){
                //拼
                Path.add(nums[i]);
                sum++;
                back(i+1,nums,k);
                Path.removeLast();
                //不拼
                back(i+1,nums,k);
            }else {
                //长度不为0
                //拼
                int now=nums[i];
                List<Integer> temp=new ArrayList<>(Path);
                boolean flag=true;
                for(int n:temp){
                    if(Math.abs(n-now)==k){
                        flag=false;
                        break;
                    }
                }
                if(flag==true){
                    sum++;
                }
                Path.add(now);
                back(i+1,nums,k);
                Path.removeLast();

                //不拼
                back(i+1,nums,k);
            }

        }
    }

}
