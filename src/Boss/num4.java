package Boss;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-12 22:21 Boss - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/12 - the current system date.  22:21 - the current system time.  2022 - the current year.  09 - the current month.  12 - the current day of the month.  22 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int n=Integer.parseInt(in.nextLine());
            String[] Line2=in.nextLine().split(" ");

            int[] prices=new int[n];
            for(int i=0;i<n;i++){
                prices[i]=Integer.parseInt(Line2[i]);
            }
            int[][] dp=new int[n][5];
            /**
             *             for(int i=0;i<n;i++){
             *                 for(int j=0;i<5;i++){
             *                     dp[i][j]=0;
             *                 }
             *             }
             */

            //0 没有任何操作
            //1 第一次买入
            //2 第一次卖出
            //3 第二次买入
            //4 第二次卖出
            //初始化
            dp[0][1]=-prices[0];
            dp[0][3]=-prices[0];
            for(int i=1;i<n;i++){
                //今天没有卖出
                //那就是昨天的价
                dp[i][0]=dp[i-1][0];
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
                dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
                dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
            }
            System.out.println(dp[n-1][4]);

        }
    }

    public static int[] absolutePrimes(int begin, int end) throws Exception {
        // 请在此添加代码
        List<Integer> temp=new ArrayList<>();
        for(int i=begin;i<end;i++){
            if(isSu(i)&&isSu(reverse(i))){
                temp.add(i);
            }
        }
        Collections.sort(temp);
        int[] ans=new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            ans[i]=temp.get(i);
        }
        return ans;
    }

    static boolean isSu(int num){
        int k=(int)Math.sqrt(num);
        for(int i=2;i<=k;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    static int reverse(int num){
        String temp=""+num;
        List<String> now=new ArrayList<>();
        for(Character a:temp.toCharArray()){
            now.add(a+"");
        }
        Collections.reverse(now);
        String t="";
        for(String a:now){
            t+=a;
        }
        return Integer.parseInt(t);
    }
}
