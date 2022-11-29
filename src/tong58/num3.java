package tong58;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-22 19:45 tong58 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/22 - the current system date.  19:45 - the current system time.  2022 - the current year.  10 - the current month.  22 - the current day of the month.  19 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int N=Integer.parseInt(in.nextLine());
            String[] strs=in.nextLine().split(" ");
            int[] nums=new int[strs.length];
            for(int i=0;i< strs.length;i++){
                nums[i]=Integer.parseInt(strs[i]);
            }
            System.out.println(rob(nums));
        }
    }

    public static int rob(int[] nums) {
        //dp -- 偷到当前家的最大钱


        //决定dp[i]的元素是这家偷不偷？
        //如果偷
        //dp[i]=dp[i-2]+nums[i];
        //如果不偷
        //dp[i]=dp[i-1]

        //dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0||nums==null){
            return 0;
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp=new int[nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
