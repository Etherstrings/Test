package Haixin;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-15 0:47 Haixin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/15 - the current system date.  0:47 - the current system time.  2022 - the current year.  09 - the current month.  15 - the current day of the month.  00 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        System.out.println(handle("abcdacd"));
    }
    static public String handle (String str) {
        // write code here
        //去除重复字符
        //保留最后一次重复的字符
        HashSet<Character> Judge=new HashSet<>();
        List<Character> ans=new ArrayList<>();
        for(int i=str.length()-1;i>=0;i--){
            if(!Judge.contains(str.charAt(i))){
                ans.add(str.charAt(i));
                Judge.add(str.charAt(i));
            }else {
                continue;
            }
        }
        Collections.reverse(ans);
        String t="";
        for(Character a:ans){
            t+=a;
        }
        return t;
    }
}
