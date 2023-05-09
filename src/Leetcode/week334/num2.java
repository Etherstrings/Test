package Leetcode.week334;

import java.math.BigInteger;

/**
 * @author Etherstrings
 * @create 2023-02-26 10:29 Leetcode.week334 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/26 - the current system date.  10:29 - the current system time.  2023 - the current year.  02 - the current month.  26 - the current day of the month.  10 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        int[] t=divisibilityArray("91221181269244172125025075166510211202115152121212341281327",21);
        System.out.println(Long.parseLong("86217457695827338")%8);
    }
    public static int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int[] res = new int[len];
        long cur = 0;
        for (int i = 0; i < word.length(); ++i) {
            int o = word.charAt(i) - '0';
            cur = (cur * 10 + o) % m;
            if (cur == 0) res[i] = 1;
        }
        return res;
    }
    public static int[] divisibilityArray1(String word, int m) {
        int[] ans=new int[word.length()];
        int temp=0;
        int BM=m;
        for(int i=0;i<word.length();i++){
            temp=temp*10+Integer.parseInt(word.charAt(i)+"");
            if(temp%BM==0){
                ans[i]=1;
            }else {
                ans[i]=0;
            }
        }
        return ans;
    }

    public static int[] divisibilityArray2(String word, int m) {
        int n = word.length();
        int[] div = new int[n];
        long num = 0;
        for (int i = 0; i < n; i++) {
            num = (num * 10 + (word.charAt(i) - '0')) % m;  // 计算前缀所表示的数值
            if (num == 0) {
                div[i] = 1;
            }
        }
        return div;
    }
}
