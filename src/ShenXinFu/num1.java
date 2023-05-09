package ShenXinFu;

/**
 * @author Etherstrings
 * @create 2023-03-07 19:30 ShenXinFu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/7 - the current system date.  19:30 - the current system time.  2023 - the current year.  03 - the current month.  07 - the current day of the month.  19 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {

    }
    public int ncov_defect (int[][] grid) {
        if(grid==null){
            return 0;
        }
        if(grid.length==0){
            return 0;
        }
        // write code here
        int m=grid.length;
        int n=grid[0].length;
        //如果当前为1 那上下左右都需要进行封上
        //如果已经被封上 那就continue
        boolean[][] used=new boolean[m][n];
        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(used[i][j]){
                    continue;
                }
                if(grid[i][j]==1){
                    sum+=gettemp(grid,used,i,j);
                }
            }
        }
        return sum;
    }

    public static int gettemp(int[][] grid,boolean[][] used,int x,int y){
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int ans=0;
        for(int i=0;i<4;i++){
            int nowx=x+dir[i][0];
            int nowy=y+dir[i][1];
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                continue;  // 越界了，直接跳过
            }
            if(used[nowx][nowy]){
                continue;
            }
            if(grid[nowx][nowy]==1){
                continue;
            }
            used[nowx][nowy]=true;
            ans++;
        }
        return ans;
    }
}
