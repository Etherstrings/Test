package meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-18 10:49 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan7 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  10:49 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  10 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class meituan7 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String word=in.nextLine();
        System.out.println(getans(word));
    }
    public static String getans(String word){
        StringBuilder sb=new StringBuilder(word);
        if(sb.reverse().toString().equals(word)){
            //已经是回文
            //设置成最小
            char[] chars=word.toCharArray();
            int times=0;
            for(int i=0;i<chars.length/2;i++){
                if(times==2){
                    break;
                }
                char n=chars[i];
                if(n!='a'){
                    times++;
                    chars[i]='a';
                    chars[chars.length-1-i]='a';
                }
            }
            word="";
            for(char n:chars){
                word+=n;
            }
            return word;
        }
        //不是回文 设置成回文
        char[] chars=word.toCharArray();
        int times=0;
        for(int i=0;i<chars.length/2;i++){
            if(times==2){
                break;
            }
            if(chars[i]!=chars[chars.length-1-i]){
                List<Character> temp=new ArrayList<>();
                temp.add(chars[i]);
                temp.add(chars[chars.length-1-i]);
                Collections.sort(temp);
                chars[i]=temp.get(0);
                chars[chars.length-1-i]=temp.get(0);
                times++;
            }
        }
        String ans="";
        for(char n:chars){
            ans+=n;
        }
        return ans;
    }
}
