package Yunzhanghu;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-09-22 22:13 Yunzhanghu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  twosum - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  22:13 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  22 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class twosum {
    public static void main(String[] args) {
        int[] nums=new int[]{2,7,11,15};
        System.out.println(twoSum(nums,9));
    }
    public static int[] twoSum (int[] nums, int target) {
        // write code here
        HashMap<Integer,Integer> Judge=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            int now=target-nums[i];
            if(Judge.containsKey(nums[i])){
                ans[0]=Judge.get(nums[i]);
                ans[1]=i;
                break;
            }else {
                Judge.put(now,i);
            }
        }
        return ans;
    }
}
