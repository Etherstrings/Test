package minunv;

import java.util.HashMap;
import java.util.Scanner;
import java.util.jar.JarEntry;

/**
 * @author Etherstrings
 * @create 2022-10-06 19:06 minunv - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  buildStr - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/6 - the current system date.  19:06 - the current system time.  2022 - the current year.  10 - the current month.  06 - the current day of the month.  19 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class buildStr {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

    }

    public static int getbiggest(String str){
        //出现次数最多的连续子串
        int[] judge=new int[24];
        HashMap<Character,Integer> jud=new HashMap<>();
        for(char a:str.toCharArray()){
            judge[a-'a']+=1;
            if(jud.containsKey(a)){
                jud.put(a,jud.get(a)+1);
            }else {
                jud.put(a,1);
            }
        }
        //如果是只有一个字母
        if(jud.size()==1){
            int ans=0;
            if(str.length()%2==0){
                ans+=str.length()/2;
                ans+=2;
                return ans;
            }else {
                ans+=str.length()/2;
                ans+=3;
                return ans;
            }
        }
        return 1;

    }

}
