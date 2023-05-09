package Di;

/**
 * @author Etherstrings
 * @create 2023-03-17 14:35 Di - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Test - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/17 - the current system date.  14:35 - the current system time.  2023 - the current year.  03 - the current month.  17 - the current day of the month.  14 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class Test {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(getmax(nums));
    }

    public static int getmax(int[] nums){
        //不能连续偷两个

        //dp[i] 偷到当前的最大值
        //0 偷
        //1 不偷

        /**
        dp[0][0]=nums[0];
        dp[0][1]=0;
        sum=Math.max(dp[0][0],dp[0][1]);
         **/
        int[] ans=new int[2];
        ans[0]=nums[0];
        ans[1]=0;
        for(int price:nums){
            //0为偷
            //就是上一个不偷的值 加上当前的钱
            int a0=ans[1]+price;
            //1为不偷
            int a1=Math.max(ans[0],ans[1]);
            ans[1]=a1;
            ans[0]=a0;
        }

        /**
        for(int i=1;i<nums.length;i++){
            //当前不偷
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
            //偷这个房间
            dp[i][0]=dp[i-1][1]+nums[i];
            sum=Math.max(dp[i][0],dp[i][1]);
        }
        return sum;
        **/
        return Math.max(ans[0],ans[1]);

    }



}
