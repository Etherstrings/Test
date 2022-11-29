package DIDI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-17 16:15 DIDI - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/17 - the current system date.  16:15 - the current system time.  2022 - the current year.  09 - the current month.  17 - the current day of the month.  16 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            //p-1
            int p=Integer.parseInt(line1[1]);
            //q-2
            int q=Integer.parseInt(line1[2]);
            int[][] todo=new int[3][n];
            for(int i=0;i<3;i++){
                //每一行
                int[] temp=new int[n];
                String[] strs=in.nextLine().split(" ");
                for(int j=0;j<temp.length;j++){
                    temp[j]=Integer.parseInt(strs[j]);
                }
                todo[i]=temp;
            }
            System.out.println(hoamany(todo,p,q));
        }
    }
    static int hoamany(int[][] todo,int pnum,int qnum){
        int bigp=-1;
        int bigq=-1;
        for(int i=0;i<todo[0].length;i++){
            int left=todo[0][i];
            int right=todo[1][i];
            int which=todo[2][i];
            if(which==1){
                bigp=Math.max(bigp,right);
            }else {
                bigq=Math.max(bigq,right);
            }
        }
        //0-1000000000
        int[] p=new int[bigp+1];
        int[] q=new int[bigq+1];
        Arrays.fill(p,0);
        Arrays.fill(q,0);
        //操作结束
        for(int i=0;i<todo[0].length;i++){
            int left=todo[0][i];
            int right=todo[1][i];
            int which=todo[2][i];
            if(which==1){
                for(int j=left+1;j<right;j++){
                    p[j]=p[j]+1;
                }
            }else {
                for(int j=left+1;j<right;j++){
                    q[j]=q[j]+1;
                }
            }
        }
        int ans=0;
        int len=Math.min(p.length,q.length);
        for(int i=0;i<len;i++){
            if(p[i]>=pnum&&q[i]>=qnum){
                ans++;
            }
        }
        return ans;
    }
}
