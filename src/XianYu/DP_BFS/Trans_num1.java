package XianYu.DP_BFS;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-02-16 13:35 XianYu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Trans_num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/16 - the current system date.  13:35 - the current system time.  2023 - the current year.  02 - the current month.  16 - the current day of the month.  13 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class Trans_num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String hex = scanner.next();
            int decimal = Integer.parseInt(hex, 16);  // 转成10进制数
            int sum = 0;
            while (decimal > 0) {
                sum += decimal % 10;  // 求每一位之和
                decimal /= 10;
            }
            System.out.println(sum);
        }

        scanner.close();
    }
}
