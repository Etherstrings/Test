package youzu;

/**
 * @author Etherstrings
 * @create 2022-09-21 22:53 youzu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/21 - the current system date.  22:53 - the current system time.  2022 - the current year.  09 - the current month.  21 - the current day of the month.  22 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public int minPathSum (int[][] grid) {
        // write code here
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    if(j==0){
                        dp[i][j]=grid[i][j];
                    }else {
                        dp[i][j]=grid[i][j]+dp[i][j-1];
                    }
                }else if(j==0){
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                }else {
                    dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
