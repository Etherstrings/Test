package hongjing;

/**
 * @author Etherstrings
 * @create 2022-10-26 20:11 hongjing - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  beanEater - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/26 - the current system date.  20:11 - the current system time.  2022 - the current year.  10 - the current month.  26 - the current day of the month.  20 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class beanEater {
    public static void main(String[] args) {
        int[][] grid={{1,2,3},{3,3,3},{4,5,6}};
        int[][] grid1={{1,0,0},{1,1,1},{0,1,0}};
        System.out.println(getbiggest1(grid));
        System.out.println(getbiggest2(grid1));


    }

    public static int getbiggest1(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];

        //初始化dp
        //初始在0，0
        //那么第一行 第一列 到达当前位置能吃到的豆子是固定的
        //第一列
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        //第一行
        for(int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }

        return dp[m-1][n-1];

    }

    public static int getbiggest2(int[][] grid){
        //k个棋盘上有豆子
        //有豆子的标为0 无豆子的标为1
        //1.初始化DP数组
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        //第一列
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            if(grid[i][0]==0){
                dp[i][0]=dp[i-1][0];
            }else {
                dp[i][0]=dp[i-1][0]+grid[i][0];
            }
        }
        //第一行
        for(int i=1;i<n;i++){
            if(grid[0][i]==0){
                dp[0][i]=dp[0][i-1];
            }else {
                dp[0][i]=dp[0][i-1]+grid[0][i];
            }

        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]==0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }else {
                    dp[i][j]=Math.max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
                }
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
