package Jibite;

import meishengke.num;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-12 15:06 Jibite - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  15:06 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  15 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        String word1=in.nextLine();
        String word2=in.nextLine();
        String k1=line1[1];
        String k2=line1[3];
        if(change(word1,Integer.parseInt(k1))<change(word2,Integer.parseInt(k2))){
            System.out.println("<");
        }else if(change(word1,Integer.parseInt(k1))==change(word2,Integer.parseInt(k2))){
            System.out.println("=");
        }else {
            System.out.println(">");
        }
    }


    public static long change(String num, int jin) {
        int len = num.length();
        long result = 0;
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            int d = Character.digit(c, jin); // 将当前位字符转换为十进制数
            result = result * jin + d;
        }
        return result;
    }
}
