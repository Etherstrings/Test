package Leetcode.week335;

/**
 * @author Etherstrings
 * @create 2023-03-05 11:21 Leetcode.week335 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/5 - the current system date.  11:21 - the current system time.  2023 - the current year.  03 - the current month.  05 - the current day of the month.  11 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public int findValidSplit(int[] nums) {
        int n=nums.length;
        if(n<2){
            return -1;
        }
        long[] dp1=new long[n];
        long[] dp2=new long[n];
        for(int i=0;i<n/2;i++){
            if(i==0){
                dp1[0]=nums[0];
                continue;
            }
            dp1[i]=dp1[i-1]*nums[i];
        }
        for(int i=n-1;i>=n/2;i--){
            if(i==n-1){
                dp2[i]=nums[i];
                continue;
            }
            dp2[i]=dp2[i+1]*nums[i];
        }
        for(int i=0;i<n-1;i++){
            long left=nums[i];
            long right=0;
        }
        return 1;
    }

    //返回值不为1就是互素的
    static int rgcd(int v1,int v2)
    {
        if(v2!=0)
            return rgcd(v2,v1%v2);
        return v1;
    }
}
