package Duxiaoman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-15 18:57 Duxiaoman - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Du2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/15 - the current system date.  18:57 - the current system time.  2022 - the current year.  09 - the current month.  15 - the current day of the month.  18 - the current hour.  57 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Du2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            int h=Integer.parseInt(line1[1]);
            List<int[]> Todo=new ArrayList<>();
            int L=Integer.MAX_VALUE;
            int R=Integer.MIN_VALUE;
            //左闭右开
            for(int i=0;i<n;i++){
                String[] linenow=in.nextLine().split(" ");
                int[] temp=new int[2];
                temp[0]=Integer.parseInt(linenow[0]);
                temp[1]=Integer.parseInt(linenow[1]);
                L=Math.min(temp[0],L);
                R=Math.max(temp[1],R);
                Todo.add(temp);
            }
            int[] heights=new int[R];
            Arrays.fill(heights,0);
            for(int[] now:Todo){
                for(int i=now[0];i<now[1];i++){
                    heights[i]=heights[i]+1;
                }
            }
            int ans=0;
            for(int height:heights){
                if(height>=h){
                    ans++;
                }
            }
            System.out.println(ans);

        }
    }
}
