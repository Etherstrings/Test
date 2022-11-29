package youmi;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-11-03 14:39 youmi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/3 - the current system date.  14:39 - the current system time.  2022 - the current year.  11 - the current month.  03 - the current day of the month.  14 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int num=Integer.parseInt(in.nextLine());
            System.out.println(judgenum(num));
        }
    }

    public static boolean judgenum(int num){
        if(num<0){
            return false;
        }
        if(num==0){
            return true;
        }
        String temp=""+num;
        String ans="";
        for(int i=temp.length();i>=0;i--){
            ans+=temp.charAt(i);
        }
        return ans.equals(temp);
    }
}
