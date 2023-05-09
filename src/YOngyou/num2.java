package YOngyou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-02-25 15:26 YOngyou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/25 - the current system date.  15:26 - the current system time.  2023 - the current year.  02 - the current month.  25 - the current day of the month.  15 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String word1=in.nextLine();
            String wored2=in.nextLine();
            if(isIsomorphic(word1,wored2)){
                System.out.println(true);
            }else {
                System.out.println(false);
            }
        }
    }
    public static boolean isIsomorphic(String s, String t) {
        //思路

        //这个是第几个出现的新字符？
        //返回按照排序的数字
        Map<Character,Integer> Judge=new HashMap<>();

        ArrayList<Integer> S2ARRAY=new ArrayList<>();
        ArrayList<Integer> T2ARRAY=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(Judge.containsKey(s.charAt(i))){
                S2ARRAY.add(Judge.get(s.charAt(i)));
            }else {
                Judge.put(s.charAt(i),Judge.size()+1);
                S2ARRAY.add(Judge.get(s.charAt(i)));
            }
        }

        Judge=new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(Judge.containsKey(t.charAt(i))){
                T2ARRAY.add(Judge.get(t.charAt(i)));
            }else {
                Judge.put(t.charAt(i),Judge.size()+1);
                T2ARRAY.add(Judge.get(t.charAt(i)));
            }
        }

        if(S2ARRAY.equals(T2ARRAY)){
            return true;
        }
        return false;
    }
}
