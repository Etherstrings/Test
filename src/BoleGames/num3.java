package BoleGames;

/**
 * @author Etherstrings
 * @create 2023-02-23 14:24 BoleGames - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/23 - the current system date.  14:24 - the current system time.  2023 - the current year.  02 - the current month.  23 - the current day of the month.  14 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    //最大拆分数
    public int maximumBonuses (int[] bonuses, long k) {
        // write code here
        // 先计算最小值
        int min=Integer.MAX_VALUE;
        for(int b:bonuses){
            min=Math.min(min,b);
        }
        return min;
    }
}
