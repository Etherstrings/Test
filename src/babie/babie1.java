package babie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-30 14:06 babie - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  babie1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/30 - the current system date.  14:06 - the current system time.  2022 - the current year.  09 - the current month.  30 - the current day of the month.  14 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class babie1 {
    public static void main(String[] args) {
        System.out.println(findbig(new int[]{1, 2, 5, 4, 3}));
    }
    public static int findbig(int[] arr){
        //元素先递增后递减
        //前提为
        //不存在单调递增或者单调递减
        int ans=-1;
        for(int i=1;i< arr.length-1;i++){
            if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
                ans=arr[i];
                break;
            }
        }
        return ans;
    }

    public static int findbig1(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int num:arr){
            max=Math.max(max,num);
        }
        return max;
    }

    public static int[] rebuild(int[] arr){
        List<Integer> ans=new ArrayList<>();
        for(int num:arr){
            if(num==0){
                ans.add(num);
                ans.add(num);
                continue;
            }
            ans.add(num);
        }
        int[] t=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            t[i]=ans.get(i);
        }
        return t;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        //记录总和
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        //如果当前总和%k有余数，分不成这样的几个桶组合
        if(sum%k!=0){
            return false;
        }
        //每个桶装多少
        int target=sum/k;

        if(nums[nums.length-1]>target){
            return false;
        }

        return dfs(nums,nums.length-1,target,0,k,used);
    }

    public static boolean dfs(int[] nums,int begin,int target,int curSum,int k,boolean[] used)
    {

        if(k==1){
            return true;
        }

        if(curSum==target)
            return dfs(nums,nums.length-1,target,0,k-1,used);//找到了一个组合,还有k-1个.

        for(int i=begin;i>=0;i--) {
            if(used[i]){
                continue;
            }
            //如果当前总和大于目标值，跳过
            if(curSum+nums[i]>target){
                continue;
            }
            //回溯
            used[i]=true;
            if(dfs(nums,i-1,target,curSum+nums[i],k,used)){
                return true;
            }
            used[i]=false;
            //如果出现相同的数字，跳过
            while(i>0&&nums[i-1]==nums[i]){
                i--;
            }
        }
        return false;
    }

    public static int damage1(int t,int k1,int k2,int d1,int d2,int x){
        //动态规划考虑
        int[][] dp=new int[t+1][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<3;j++){
                dp[i][j]=0;
            }
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=Math.max(i-1>=0?dp[i-1][0]:0,(i-k1>=0?dp[i-k1][0]:0)+d1);
            dp[i][1]=Math.max(i-1>=0?dp[i-1][1]:0,(i-k2>=0?dp[i-k2][1]:0)+d2);
            dp[i][2]=Math.max(i-1>=0?dp[i-1][2]:0, (i-k1>=0?dp[i-k1][0]:0)+(i-k2>=0?dp[i-k2][1]:0)+(d1+d2)*(1+x));
            if(dp[i][2]>dp[i][0]+dp[i][1]){
                dp[i][0]=i-k1>=0?dp[i-k1][0]+d1*(1+x):d1*(1+x);
                dp[i][1]=i-k2>=0?dp[i-k2][1]+d2*(1+x):d2*(1+x);
            }else {
                dp[i][2]=dp[i][0]+dp[i][1];
            }
        }
        return dp[t][2];
    }

    public static int damage2(int t,int k1,int k2,int d1,int d2,int x){
        int[][] dp=new int[t+1][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<3;j++){
                dp[i][j]=0;
            }
        }
        for(int i=0;i<dp.length;i++){
            //B的角色伤害更新不变
            dp[i][1]=Math.max(i-1>=0?dp[i-1][1]:0,(i-k2>=0?dp[i-k2][1]:0)+d2);
            //A的角色伤害更新依靠于当前B
            //当前打没打？
            if(dp[i][1]==(i-k2>=0?dp[i-k2][1]:0)+d2){
                //打了
                dp[i][0]=(i-k1>=0?dp[i-1][0]:0)+d1;
            }else {
                dp[i][0]=Math.max(i-1>=0?dp[i-1][0]:0,(i-k1>=0?dp[i-k1][0]:0)+d1);
            }

            dp[i][2]=Math.max(i-1>=0?dp[i-1][2]:0, (i-k1>=0?dp[i-k1][0]:0)+(i-k2>=0?dp[i-k2][1]:0)+(d1+d2));
            if(dp[i][2]>dp[i][0]+dp[i][1]){
                dp[i][0]=i-k1>=0?dp[i-k1][0]+d1:d1;
                dp[i][1]=i-k2>=0?dp[i-k2][1]+d2:d2;
            }else {
                dp[i][2]=dp[i][0]+dp[i][1];
            }
        }
        return dp[t][2];
    }

    public static int damage3(int t,int k1,int k2,int d1,int d2,int x){
        int[][] dp=new int[t+1][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<3;j++){
                dp[i][j]=0;
            }
        }
        for(int i=0;i<dp.length;i++){

            dp[i][0]=Math.max(i-1>=0?dp[i-1][0]:0,(i-k1>=0?dp[i-k1][0]:0)+d1);
            //B的角色伤害不变
            dp[i][1]=Math.max(i-1>=0?dp[i-1][1]:0,(i-k2>=0?dp[i-k2][1]:0)+d2);


            dp[i][2]=Math.max(i-1>=0?dp[i-1][2]:0, (i-k1>=0?dp[i-k1][0]:0)+(i-k2>=0?dp[i-k2][1]:0)+(d1)*(1+x)+d2);
            if(dp[i][2]>dp[i][0]+dp[i][1]){
                dp[i][0]=i-k1>=0?dp[i-k1][0]+d1*(1+x):d1*(1+x);
                dp[i][1]=i-k2>=0?dp[i-k2][1]+d2:d2;
            }else {
                dp[i][2]=dp[i][0]+dp[i][1];
            }
        }
        return dp[t][2];
    }

}
