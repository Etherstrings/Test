package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-03 16:35 DP - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L120 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/3 - the current system date.  16:35 - the current system time.  2023 - the current year.  03 - the current month.  03 - the current day of the month.  16 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L120 {
    public static void main(String[] args) {
        List<List<Integer>> temp=new ArrayList<>();
        List<Integer> n=new ArrayList<>();

        n.add(2);
        temp.add(n);

        n=new ArrayList<>();
        n.add(3);
        n.add(4);
        temp.add(n);

        n=new ArrayList<>();
        n.add(6);
        n.add(5);
        n.add(7);
        temp.add(n);

        n=new ArrayList<>();
        n.add(4);
        n.add(1);
        n.add(8);
        n.add(3);
        temp.add(n);

        System.out.println(minimumTotal(temp));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int ans=Integer.MAX_VALUE;
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[][] dp=new int[triangle.size()][];
        int[] first=new int[]{triangle.get(0).get(0)};
        dp[0]=first;
        for(int i=1;i<triangle.size();i++){
            int[] temp=new int[triangle.get(i).size()];
            for(int j=0;j<triangle.get(i).size();j++){
                //只能从的节点过来
                int now=triangle.get(i).get(j);
                if(j==0){
                    temp[j]=dp[i-1][j]+now;
                    continue;
                }
                if(j==triangle.get(i).size()-1){
                    temp[j]=dp[i-1][dp[i-1].length-1]+now;
                    continue;
                }
                temp[j]=Math.min(dp[i-1][j]+now,dp[i-1][j-1]+now);
            }
            dp[i]=temp;
        }
        for(int i=0;i<dp[dp.length-1].length;i++){
            ans=Math.min(dp[dp.length-1][i],ans);
        }
        return ans;
    }
}
