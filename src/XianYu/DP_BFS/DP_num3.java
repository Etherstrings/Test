package XianYu.DP_BFS;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-02-16 14:11 XianYu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  DP_num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/16 - the current system date.  14:11 - the current system time.  2023 - the current year.  02 - the current month.  16 - the current day of the month.  14 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class DP_num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            Integer N=Integer.parseInt(in.nextLine());
            int[][] gird=new int[N][8];
            for(int i=0;i<N;i++){
                String[] damage=in.nextLine().split(" ");
                for(int j=0;j<8;j++){
                    gird[i][j]=Integer.parseInt(damage[j]);
                }
            }
            System.out.println(getdamage(gird));
        }
    }

    public static int getdamage(int[][] gird){
        //只能往下 左下或者右下
        int[][] dp=new int[gird.length][gird[0].length];
        int level=gird.length;
        int col=gird[0].length;
        //初始化第一行
        for(int i=0;i<8;i++){
            dp[0][i]=gird[0][i];
        }
        for(int i=1;i<level;i++){
            for(int j=0;j<col;j++){
                if(j==0){
                    //左边一列
                    //上 右上
                    dp[i][j]=Math.min(dp[i-1][j]+gird[i][j],dp[i-1][j+1]+gird[i][j]);
                }else if(j==col-1){
                    //右边一列
                    //上 左上
                    dp[i][j]=Math.min(dp[i-1][j]+gird[i][j],dp[i-1][j-1]+gird[i][j]);
                }else {
                    //中间
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+gird[i][j],dp[i-1][j-1]+gird[i][j]),dp[i-1][j+1]+gird[i][j]);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<8;i++){
            ans=Math.min(ans,dp[level-1][i]);
        }
        return ans;
    }
}
