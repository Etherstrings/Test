package DIDI;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-17 16:59 DIDI - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/17 - the current system date.  16:59 - the current system time.  2022 - the current year.  09 - the current month.  17 - the current day of the month.  16 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            //回溯
            String str=in.nextLine();

        }
    }

    Integer get(String str){
        String now="";
        if(str.length()==1){
            return 3;
        }
        for(int i=0;i<str.length();i++ ){
            Character temp=str.charAt(i);
            if(i==0){
                if(temp.equals('?')){
                    int next=Integer.parseInt(str.charAt(i+1)+"");
                }
            }
        }
        return 0;
    }

}
