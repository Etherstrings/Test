package XianYu.DP_BFS;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-02-16 13:37 XianYu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  DP_num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/16 - the current system date.  13:37 - the current system time.  2023 - the current year.  02 - the current month.  16 - the current day of the month.  13 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class DP_num2 {
    //Problem Description
    //某人第1个月初买来一对刚出生的小豚鼠，每一对豚鼠从第4个月开始，每月初都会生下一对小豚鼠。
    //
    //
    //Input
    //输入包含多组数据，每组数据包含一个非负整数N(0
    //
    //
    //
    //Output
    //对于每组数据，输出第N月末的豚鼠对数。
    //
    //
    //Sample Input
    //1
    //4
    //6
    //10
    //
    //
    //
    //
    //Sample Output
    //1
    //2
    //4
    //19
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(fib(n));
        }

        scanner.close();
    }

    public static int fib(int n) {
        //如果新增的时间大于等于4个月，那就开始生产
        if(n==1||n==2||n==3){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        //不可以生产的
        //可以生产的
        for(int i=4;i<=n;i++){
            //可以生产的有哪些
            int make=dp[(i+1)-4];
            dp[i]=dp[i-1]+make;
        }
        return dp[n];
    }
}
