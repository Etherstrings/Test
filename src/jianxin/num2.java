package jianxin;

/**
 * @author Etherstrings
 * @create 2023-03-04 16:12 jianxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/4 - the current system date.  16:12 - the current system time.  2023 - the current year.  03 - the current month.  04 - the current day of the month.  16 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        System.out.println(CalcTotal(new int[]{1,9,2}));
    }

    public static long CalcTotal(int[] arr){
        long ans=0;
        int[] dp=new int[arr.length];
        long[] PreSum=new long[arr.length];
        //包括当前位置的前缀和
        for(int i=0;i<arr.length;i++){
            if(i==0){
                PreSum[i]=arr[i];
            }
            PreSum[i]=PreSum[i-1]+arr[i];
        }
        for(int i=arr.length-1;i>=0;i--){
            //维护当前位置的最大值
            if(i==arr.length-1){
                dp[i]=arr[i];
                continue;
            }
            int now=arr[i];
            if(now>=dp[i+1]){
                dp[i]=now;
            }else {
                dp[i]=dp[i+1];
            }
        }
        //a[left]小于a[k]
        //并且a[left]右边<=a[k]
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    if(arr[i+1]<=arr[j]){
                        ans+=arr[i];
                        ans+=arr[j];
                    }
                }
            }
        }
        return ans;
    }
}
