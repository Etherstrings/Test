package meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-12 20:08 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  20:08 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  20 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int q=Integer.parseInt(line1[1]);
        int[] tasks=new int[q];
        String[] line2=in.nextLine().split(" ");
        for(int i=0;i<q;i++){
            //这里做了减的处理
            tasks[i]=Integer.parseInt(line2[i])-1;
        }
        int level= (int) Math.pow(2,n);
        int rol=(int) Math.pow(2,n);
        //0的时候全白
        char[][] getgrid=new char[level][rol];
        for(int i=0;i<level;i++){
            for(int j=0;j<rol;j++){
                getgrid[i][j]='W';
            }
        }
    }

    public static char[][] getgrid(int n,char[][] getgrid){
        if(n==0){
            return getgrid;
        }
        int level= (int) Math.pow(2,n);
        int rol=(int) Math.pow(2,n);
        char[][] now=new char[level][rol];
        for(int i=0;i<level;i++){
            Arrays.fill(now[i],'B');
        }
        int show=(int) Math.pow(2,n);
        for(int i=0;i<show;i++){

        }
        return getgrid;
    }
}
