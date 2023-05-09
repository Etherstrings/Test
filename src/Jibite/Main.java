package Jibite;

/**
 * @author Etherstrings
 * @create 2023-03-12 15:26 Jibite - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Main - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  15:26 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  15 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
import java.util.*;

public class Main {
    static int[] data,ff, bb;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[] data = new int[n];
        int sum = 0, cnt = 0;
        for (int i = 0; i < n; ++i) {
            data[i] = sc.nextInt();
            sum += data[i];
            if (data[i] > 0) cnt++;
        }

        // 由于solve不能处理正数元素小于等于2的情况，因此需要单独处理
        if (cnt <= 2) {
            Arrays.sort(data);
            System.out.println(data[n - 1] + data[n - 2]);

        }else{
            int s1 = solve(data); // 正的最大子段
            for (int i = 0; i < n; ++i) // 求反数的最大子段，相当于求最小子段
                data[i] = -data[i];
            int s2 = sum + solve(data); // 去除最小子段
            System.out.println(Math.max(s1, s2));
        }



    }

    private static int solve(int[] data) {
        int n = data.length;
        int[] ff = new int[n];
        int[] bb = new int[n];

        int s = 0;
        // ff[i]表示范围0->i的数据构成的最大子段值，可以不取，值永远非负
        for (int i = 0; i < n; ++i) {
            if (i > 0) ff[i] = ff[i - 1];
            else ff[i] = 0;
            if (s < 0) s = 0; // s表示从0->i，以i结尾的最大子段值
            s += data[i];
            ff[i] = Math.max(ff[i], s); // 取以i结尾的最大字段值与历史上最大的最大子段值的最大值
        }

        s = 0;
        // 这个步骤和上面类似，只不过是从右往左处理，bb[i]表示从n-1~i构成的最大字段值
        for (int i = n - 1; i >= 0; --i) {
            if (i < n - 1) bb[i] = bb[i + 1];
            else bb[i] = 0;
            if (s < 0) s = 0;
            s += data[i];
            bb[i] = Math.max(bb[i], s);
        }

        // 遍历断开的位置，取最大值
        int ans = 0;
        for (int i = 0; i < n - 1; ++i)
            ans = Math.max(ans, ff[i] + bb[i + 1]);
        return ans;
    }
}

