package fenghuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-19 11:05 fenghuo - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/19 - the current system date.  11:05 - the current system time.  2022 - the current year.  09 - the current month.  19 - the current day of the month.  11 - the current hour.  05 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            int m=Integer.parseInt(line1[1]);
            int k=Integer.parseInt(line1[2]);
            int[][] juzhen=new int[n][m];
            //填充矩阵
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    juzhen[i][j]=getgcd(i+1,j+1);
                }
            }
            //求子矩阵的和
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i+k<=n&&j+k<=m){
                        sum+=getsum(i,j,k,juzhen);
                    }
                }
            }
            System.out.println(sum);

        }

    }
    static int getsum(int level,int col,int k,int[][] juzhen){
        int sum=0;
        for(int i=level;i<level+k;i++){
            for(int j=col;j<col+k;j++){
                sum+=juzhen[i][j];
            }
        }
        return sum;
    }
    static int getgcd(int i,int j){
        int a=Math.max(i,j);
        int[] b=new int[a];
        for(int k=1;k<=a;k++){
            if(i%k==0&&j%k==0){
                b[k-1]=k;
            }
        }
        Arrays.sort(b);
        return b[b.length-1];
    }
}
