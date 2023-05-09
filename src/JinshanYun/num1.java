package JinshanYun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-08 20:30 JinshanYun - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/8 - the current system date.  20:30 - the current system time.  2023 - the current year.  03 - the current month.  08 - the current day of the month.  20 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] words=in.nextLine().split(" ");
            System.out.println(getans(words));
        }
    }

    public static String getans(String[] words){
        int left=0;
        String last="";
        List<String> a=new ArrayList<>();
        a.add(words[0]);
        for(char n:words[0].toCharArray()){
            last+=Character.toLowerCase(n);
        }
        for(int i=1;i<words.length;i++){
            String t="";
            for(char n:words[i].toCharArray()){
                t+=Character.toLowerCase(n);
            }
            if(t.equals(last)){
                continue;
            }else {
                last=t;
                a.add(words[i]);
            }
        }
        String ans="";
        for(int i=0;i<a.size();i++){
            if(i==a.size()-1){
                ans+=a.get(i);
                continue;
            }
            ans+=a.get(i)+" ";
        }
        return ans;
    }
}
