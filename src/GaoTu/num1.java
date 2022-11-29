package GaoTu;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-16 19:20 GaoTu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/16 - the current system date.  19:20 - the current system time.  2022 - the current year.  09 - the current month.  16 - the current day of the month.  19 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            String pattern=in.nextLine();
            boolean Flag=Pipei(str,pattern);
            System.out.println(Flag);
        }
    }

    static boolean Pipei(String str,String pattern){
        if(str==null&&pattern==null){
            return true;
        }
        if(str==null&&pattern!=null){
            if(pattern.charAt(pattern.length()-1)=='*'){
                return true;
            }
        }
        if(pattern.equals(".*")){
            return true;
        }
        return str.matches(pattern);
    }
}
