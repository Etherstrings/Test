package Leetcode.week337;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-03-19 10:24 Leetcode.week337 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  10:24 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  10 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        int[][] grid1=new int[][]{{0,3,6},{5,8,1},{2,7,4}};
        int[][] grid2={{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}};
        System.out.println(checkValidGrid(grid2));

    }
    public static boolean checkValidGrid(int[][] grid) {
        Queue<int[]> judge=new LinkedList<>();
        if(grid[0][0]!=0){
            return false;
        }
        int[] start={0,0};
        int level=grid.length;
        int col=grid[0].length;
        judge.offer(start);
        int[][] moves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1},
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        //每次查找可以走的路线，如果找不到，那就是G了
        boolean flag=true;
        boolean[][] used=new boolean[level][col];
        used[0][0]=true;

        while(!judge.isEmpty()){
            int[] now=judge.poll();
            int x=now[0];
            int y=now[1];
            boolean tflag=false;
            int index=grid[x][y];
            if(index==level*col-1){
                flag=true;
                break;
            }
            int times=8;
            for (int[] move : moves) {
                int dx = move[0];
                int dy = move[1];
                int nowx = x + dx;
                int nowy = y + dy;
                if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                    times--;
                    continue;  // 越界了，直接跳过
                }
                if(used[nowx][nowy]){
                    times--;
                    continue;
                }
                if(grid[nowx][nowy]==index+1){
                    tflag=true;
                    judge.offer(new int[]{nowx,nowy});
                    used[nowx][nowy]=true;
                    break;
                }

            }
            if(tflag==false){

                flag=false;

                break;
            }

        }

        return flag;
    }
}
