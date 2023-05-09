package XianYu.DP_BFS;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-02-16 14:30 XianYu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  BFS_num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/16 - the current system date.  14:30 - the current system time.  2023 - the current year.  02 - the current month.  16 - the current day of the month.  14 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class BFS_num4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line=in.nextLine().split(" ");
            Integer N=Integer.parseInt(line[0]);
            Integer M=Integer.parseInt(line[1]);
            String[][] grid=new String[N][];
            int[] start=new int[2];
            int[] end=new int[2];
            for(int i=0;i<N;i++){
                String[] now=in.nextLine().split(" ");
                grid[i]=now;
                for(int j=0;j<now.length;j++){
                    if(now[j].equals("s")){
                        start[0]=i;
                        start[1]=j;
                    }
                    if(now[j].equals("d")){
                        end[0]=i;
                        end[1]=j;
                    }
                }

            }

            System.out.println(BFS(grid,start,end));
        }
    }

    public static int BFS(String[][] grid,int[] start,int[] end){
        //从start查到end
        return -1;

    }



}
