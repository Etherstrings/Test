package shuziguangdong;

/**
 * @author Etherstrings
 * @create 2022-11-26 19:18 shuziguangdong - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/26 - the current system date.  19:18 - the current system time.  2022 - the current year.  11 - the current month.  26 - the current day of the month.  19 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3,7,8,9,24,2,1,5,4,7,1};
        int[] ans=nextBigger(nums);
        for(int num:ans){
            System.out.println(num);
        }
    }
    public static int[] nextBigger (int[] nums) {
        // write code here
        int[] ans=new int[nums.length];
        if(nums.length==1){
            ans[0]=-1;
            return ans;
        }
        for(int i=0;i<nums.length;i++){
            int now=nums[i];
            if(i==0){
                boolean flag=false;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]>now){
                        flag=true;
                        ans[i]=nums[j];
                        break;
                    }else {
                        continue;
                    }
                }
                if(flag==false){
                    ans[i]=-1;
                }
                continue;
            }
            if(i==nums.length-1){
                boolean flag=false;
                for(int j=0;j<nums.length-1;j++){
                    if(nums[j]>now){
                        flag=true;
                        ans[i]=nums[j];
                        break;
                    }else {
                        continue;
                    }
                }
                if(flag==false){
                    ans[i]=-1;
                }
                continue;
            }
            //剩下的都是中间的数字
            boolean flag=false;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>now){
                    flag=true;
                    ans[i]=nums[j];
                    break;
                }else {
                    continue;
                }
            }
            if(flag==false){
                for(int j=0;j<i;j++){
                    if(nums[j]>now){
                        flag=true;
                        ans[i]=nums[j];
                        break;
                    }else {
                        continue;
                    }
                }
                if(flag==false){
                    ans[i]=-1;
                }
            }
        }
        return ans;
    }
}
