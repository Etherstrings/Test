package huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-10-12 19:05 huawei - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/12 - the current system date.  19:05 - the current system time.  2022 - the current year.  10 - the current month.  12 - the current day of the month.  19 - the current hour.  05 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            Set<Character> set=new HashSet<>();
            for(char a:str.toCharArray()){
                set.add(a);
            }
            if(set.size()==1){
                int n=str.length();
                str="";
                str+=n;
                str+="(";
                for(char a:set){
                    str+=a;
                }
                str+=")";
            }
            System.out.println(str);
        }
    }


}
