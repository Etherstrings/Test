package xinhuasan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-18 20:04 xinhuasan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/18 - the current system date.  20:04 - the current system time.  2022 - the current year.  10 - the current month.  18 - the current day of the month.  20 - the current hour.  04 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        str=str.substring(1,str.length()-1);
        List<String> temp=new ArrayList<>();
        String now="";
        for(int i=0;i<str.length();i++){
            if(i==str.length()-1){
                now+=str.charAt(i);
                temp.add(now);
                continue;
            }
            char t=str.charAt(i);
            if(t==' '){
                temp.add(now);
                now="";
                continue;
            }else {
                now+=t;
            }
        }
        //上面实现了 spit(" ")
        String ans="";
        for(int i=0;i<temp.size();i++){
            if(i==temp.size()-1){
                ans+=myr(temp.get(i));
                continue;
            }
            ans+=myr(temp.get(i));
            ans+=" ";
        }
        System.out.println("\""+ans+"\"");
    }

    public static String myr(String t){
        String now="";
        for(int i=t.length()-1;i>=0;i--){
            now+=t.charAt(i);
        }
        return now;
    }
}
