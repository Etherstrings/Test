package GaoTu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-16 19:21 GaoTu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/16 - the current system date.  19:21 - the current system time.  2022 - the current year.  09 - the current month.  16 - the current day of the month.  19 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String num=in.nextLine();
            List<Character> rev=new ArrayList<>();
            for(Character a:num.toCharArray()){
                rev.add(a);
            }
            Collections.reverse(rev);
            String now="";
            for(Character b:rev){
                now+=b;
            }
            System.out.println(num.equals(now));
        }
    }


}
