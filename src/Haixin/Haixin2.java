package Haixin;

import java.util.HashSet;

/**
 * @author Etherstrings
 * @create 2022-09-15 0:54 Haixin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Haixin2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/15 - the current system date.  0:54 - the current system time.  2022 - the current year.  09 - the current month.  15 - the current day of the month.  00 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Haixin2 {
    public int uppercase (String str) {
        // write code here
        int sum=0;
        HashSet<Character> Big=new HashSet<>();
        Big.add('A');
        Big.add('E');
        Big.add('I');
        Big.add('O');
        Big.add('U');
        HashSet<Character> small=new HashSet<>();
        small.add('a');
        small.add('e');
        small.add('i');
        small.add('o');
        small.add('u');
        for(Character a:str.toCharArray()){
            //先判断是不是大写字母
            if(Character.isUpperCase(a)){
                //是大写字母
                //大写字母--只有大写的元音字母才加
                if(Big.contains(a)){
                    sum++;
                }
            }else {
                //不是大写字母
                //小写字母--不是小写的原因就加
                if(!small.contains(a)){
                    sum++;
                }
            }
        }
        return sum;
    }
}
