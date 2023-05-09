package JiZhiGame;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-02-26 15:22 JiZhiGame - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/26 - the current system date.  15:22 - the current system time.  2023 - the current year.  02 - the current month.  26 - the current day of the month.  15 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int numDifferentIntegers (String word) {
        // write code here
        Queue<Character> queue=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        for(char n:word.toCharArray()){
            if(Character.isDigit(n)){
                queue.offer(n);
            }else {
                if(queue.size()==0){
                    continue;
                }else {
                    String t="";
                    while(!queue.isEmpty()){
                        t+=queue.poll();
                    }
                    set.add(Integer.parseInt(t));
                }
                continue;
            }
        }
        int ans=0;
        for(int n:set){
            ans+=n;
        }
        return ans;

    }
}
