package ShanSong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-25 16:21 ShanSong - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/25 - the current system date.  16:21 - the current system time.  2022 - the current year.  09 - the current month.  25 - the current day of the month.  16 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String line=in.nextLine();
        line=line.substring(1,line.length()-1);
        if(line.indexOf(",")==-1){
            System.out.println(line);
        }else {
            List<String> ans=new ArrayList<>();
           String[] strs=line.split(",");
           for(int i=strs.length-1;i>=0;i--){
               ans.add(strs[i]);
           }
            String t="";
            t+="{";
            for(int i=0;i<ans.size();i++){
                if(i==ans.size()-1){
                    t+=ans.get(i);
                    continue;
                }
                t+=ans.get(i)+",";
            }
            t+="}";
            System.out.println(t);
        }
    }
}
