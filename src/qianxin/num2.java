package qianxin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-03-19 19:30 qianxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  19:30 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  19 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {

    public int LSubSequence (int N, ArrayList<Integer> sequence) {
        // write code here
        int[] dp=new int[N];
        Arrays.fill(dp,1);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(sequence.get(i)>sequence.get(j)){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
