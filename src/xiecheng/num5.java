package xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-29 19:13 xiecheng - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num5 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/29 - the current system date.  19:13 - the current system time.  2023 - the current year.  03 - the current month.  29 - the current day of the month.  19 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] ans=geta(n,k);
        for(int i=1;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static int[] geta(int n,int k){
        int index=k*2-1;
        //前边的都进行倒叙
        int[] ans=new int[n+1];
        //这个位置设置为最大值
        ans[index]=n;
        for(int i=1;i<index;i+=2){
            ans[i]=i+1;
            ans[i+1]=i;
        }
        for(int i=index+1;i<=n;i++){
            ans[i]=i-1;
        }
        return ans;
    }
}
