package meishengke;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-22 21:19 meishengke - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  21:19 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  21 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            String num=in.nextLine();
            String ans="";
            if("0.00".equals(num)||"0.0".equals("num")){
                ans="零元";
            }
        String zhengshu="";
        String fen="";
        int index=-1;
        for(int i=0;i<num.length();i++){
            Character now=num.charAt(i);
            if(now=='.'){
                index=i;
                break;
            }
            zhengshu+=now;
        }
        for(int i=index+1;i<num.length();i++){
            fen+=num.charAt(i);
        }

    }

}
