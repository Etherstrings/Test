import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-09 11:17 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Jingdong2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/9 - the current system date.  11:17 - the current system time.  2022 - the current year.  09 - the current month.  09 - the current day of the month.  11 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Jingdong2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int len = Integer.parseInt(in.nextLine());
            String numstr = in.nextLine();
            String[] split = numstr.split(" ");
            int[] nums = new int[len];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            int jishu = 0;
            int oushu = 0;
            for (int now : nums) {
                if (now % 2 == 1) {
                    jishu++;
                } else {
                    oushu++;
                }
            }
            int ans = 0;
            //奇数有几种组合方式？
            for(int i=2;i<=jishu;i+=2){
                ans +=Zuhe(i,jishu);
            }
            //两两组合
            //偶数有几种组合方式？
            for(int i=2;i<=oushu;i++){
                ans+=Zuhe(i,oushu);
            }
            System.out.println(ans);
        }
    }

        //n个里面取m
        static int Zuhe(int m, int n) {
            int sum1 = 1;
            for (int i = 1; i <= m; i++) {
                sum1 = sum1 * i;
            }

            int sum2 = 1;
            for (int j = n; j >= n - m + 1; j--) {
                sum2 = sum2 * j;
            }

            return sum2 / sum1;


    }
}