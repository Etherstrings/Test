package meituan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-10 16:38 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/10 - the current system date.  16:38 - the current system time.  2022 - the current year.  09 - the current month.  10 - the current day of the month.  16 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meituan3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            //动态规划
            //宝藏个数
            int n=Integer.parseInt(in.nextLine());
            String[] line2=in.nextLine().split(" ");
            String[] line3=in.nextLine().split(" ");
            //宝藏在的房间号--房间号
            int[] num_index=new int[n];
            for(int i=0;i<n;i++){
                num_index[i]=Integer.valueOf(line2[i]);
            }
            //宝藏的--价值
            int[] num_value=new int[n];
            for(int i=0;i<n;i++){
                num_value[i]=Integer.valueOf(line3[i]);
            }
            //到达当前房间的最大价值是多少？
            //最大房间
            int max=-1;
            for(int i=0;i<num_index.length;i++){
                max=Math.max(max,num_index[i]);
            }
            //房间里有多少价值？
            HashMap<Integer,Integer> F_Baozang=new HashMap<>();
            for(int i=0;i<num_index.length;i++){
                //房间号
                int index=num_index[i];
                int sum=0;
                if(F_Baozang.containsKey(index)){
                    sum=F_Baozang.get(index);
                    sum+=num_value[i];
                    F_Baozang.put(index,sum);
                }else {
                    sum+=num_value[i];
                    F_Baozang.put(index,sum);
                }
            }

            int[] dp=new int[max+1];
            //可以到达哪些房间？
            //全都都可以达到
            //初始化
            //一号房间为0
            dp[1]=0;
            if(F_Baozang.containsKey(2)){
                dp[2]=F_Baozang.get(2);
            }
            for(int i=3;i<=max;i++){
                int temp=0;
                if(F_Baozang.containsKey(i)){
                    temp=F_Baozang.get(i);
                }
                dp[i]=Math.max(dp[i/2]+temp,dp[(i-1)/2]);
            }
            System.out.println(dp[max]);
        }
    }
}
