package MihaYou;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-19 20:29 MihaYou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  20:29 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  20 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    //M*N
    //2 6

    //RRGGBB
    //RGBGRR

    //RRGGGG
    //RGGGRR

    //3
    //6

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] word1=in.nextLine().split(" ");
            int N=Integer.parseInt(word1[0]);
            int M=Integer.parseInt(word1[1]);
            char[][] grid=new char[N][M];
            char[][] fgrid=new char[N][M];
            //R正常
            //G和B不一样
            for(int i=0;i<N;i++){
                String line=in.nextLine();
                char[] temp=new char[M];
                char[] ftemp=new char[M];
                for(int j=0;j<line.length();j++){
                    temp[j]=line.charAt(j);
                    if(line.charAt(j)=='R'){
                        ftemp[j]=line.charAt(j);
                    }else {
                        ftemp[j]='B';
                    }
                }
                grid[i]=temp;
                fgrid[i]=ftemp;
            }
            int x=numIslands1(grid);
            int y=numIslands(fgrid);
            System.out.println(Math.abs(x-y));
        }

    }
    public static int getans(char[][] grid){
        int level=grid.length;
        int col=grid[0].length;
        //先行 后列
        int sum=0;
        for(char[] le:grid){
            sum+=countSegments(le);
        }

        for(int i=0;i<col;i++){
            char[] temp=new char[level];
            for(int j=0;j<level;j++){
                temp[j]=grid[j][i];
            }
            sum+=countSegments(temp);
        }
        return sum;
    }

    public static int countSegments(char[] s) {
        char last=s[0];
        int index=0;
        int sum=0;
        for(int i=1;i<s.length;i++){
            char now=s[i];
            if(i==s.length-1){
                if(now==last){
                    int len=i-index+1;
                    if(len>=2){
                        sum++;
                    }
                }else {
                    int len=i-index;
                    if(len>=2){
                        sum++;
                    }
                    index=i;
                    last=now;
                }
                continue;
            }
            if(now!=last){
                int len=i-index;
                if(len>=2){
                    sum++;
                }
                index=i;
                last=now;
            }else {
                continue;
            }
        }
        return sum;
    }

    public static int numIslands1(char[][] grid) {
        //BFS应该可以直接在这里BFS
        boolean[][] visisted=new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visisted[i][j]&&grid[i][j]=='R'){
                    result++;
                    visisted[i][j]=true;
                    BFS(grid,visisted,i,j,'R');
                }
            }
        }

        visisted=new boolean[grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visisted[i][j]&&grid[i][j]=='B'){
                    result++;
                    visisted[i][j]=true;
                    BFS(grid,visisted,i,j,'B');
                }
            }
        }

        visisted=new boolean[grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visisted[i][j]&&grid[i][j]=='G'){
                    result++;
                    visisted[i][j]=true;
                    BFS(grid,visisted,i,j,'G');
                }
            }
        }
        return result;
    }

    public static int numIslands(char[][] grid) {
        //BFS应该可以直接在这里BFS
        boolean[][] visisted=new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visisted[i][j]&&grid[i][j]=='R'){
                    result++;
                    visisted[i][j]=true;
                    BFS(grid,visisted,i,j,'R');
                }
            }
        }

        visisted=new boolean[grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visisted[i][j]&&grid[i][j]=='B'){
                    result++;
                    visisted[i][j]=true;
                    BFS(grid,visisted,i,j,'B');
                }
            }
        }
        return result;
    }

    static void BFS(char[][] grid,boolean[][] visisted,int x,int y,char T){
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
        Queue<int[]> Judge=new LinkedList<>();
        Judge.offer(new int[]{x,y});
        visisted[x][y]=true;
        while(!Judge.isEmpty()){
            int[] now=Judge.poll();
            for(int i=0;i<4;i++){
                int nowx=now[0]+dir[i][0];
                int nowy=now[1]+dir[i][1];
                if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                    continue;  // 越界了，直接跳过
                }
                if(grid[nowx][nowy]==T&&!visisted[nowx][nowy]){
                    Judge.offer(new int[]{nowx,nowy});
                    visisted[nowx][nowy]=true;
                }
            }
        }
    }


}
