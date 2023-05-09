package Leetcode.week334;

/**
 * @author Etherstrings
 * @create 2023-02-26 10:29 Leetcode.week334 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/26 - the current system date.  10:29 - the current system time.  2023 - the current year.  02 - the current month.  26 - the current day of the month.  10 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    //6369. 左右元素和的差值 显示英文描述
    //通过的用户数0
    //尝试过的用户数0
    //用户总通过次数0
    //用户总提交次数0
    //题目难度Easy
    //给你一个下标从 0 开始的整数数组 nums ，请你找出一个下标从 0 开始的整数数组 answer ，其中：
    //
    //answer.length == nums.length
    //answer[i] = |leftSum[i] - rightSum[i]|
    //其中：
    //
    //leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
    //rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
    //返回数组 answer 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [10,4,8,3]
    //输出：[15,1,11,22]
    //解释：数组 leftSum 为 [0,10,14,22] 且数组 rightSum 为 [15,11,3,0] 。
    //数组 answer 为 [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22] 。
    //示例 2：
    //
    //输入：nums = [1]
    //输出：[0]
    //解释：数组 leftSum 为 [0] 且数组 rightSum 为 [0] 。
    //数组 answer 为 [|0 - 0|] = [0] 。

    public int[] leftRigthDifference(int[] nums) {
        if(nums.length==1){
            return new int[]{0};
        }
        int[] leftsum=new int[nums.length];
        int[] rightsum=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                leftsum[0]=0;
                continue;
            }
            leftsum[i]=leftsum[i-1]+nums[i-1];
        }

        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                rightsum[nums.length-1]=0;
                continue;
            }
            rightsum[i]=rightsum[i+1]+nums[i+1];
        }

        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=Math.abs(leftsum[i]-rightsum[i]);
        }
        return ans;

    }
}
