import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-07-23 10:51 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/23 - the current system date.  10:51 - the current system time.  2022 - the current year.  07 - the current month.  23 - the current day of the month.  10 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L2 {
    public static void main(String[] args) {
        L2 a=new L2();
        int[] temp=new int[]{2,4,11,3};
        int[] test=a.twoSum(temp,6);
        for(int b:test){
            System.out.print(b);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> Judge=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            if(Judge.containsKey(target-nums[i])){
                //已经找到了 而且这个数就是重复的
                ans[0]=i;
                break;
            }
            Judge.put(target-nums[i],nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(i==ans[0]){
                continue;
            }
            if(nums[i]==Judge.get(nums[ans[0]])){
                ans[1]=i;
                return ans;
            }
        }

        int temp=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(Judge.containsKey(nums[i])){
                ans[0]=i;
                temp=Judge.get(nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i==ans[0]){
                continue;
            }
            if(temp==nums[i]){
                ans[1]=i;
            }
        }
        return ans;
    }
}
