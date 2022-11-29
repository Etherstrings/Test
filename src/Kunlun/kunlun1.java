package Kunlun;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Etherstrings
 * @create 2022-09-17 20:20 Kunlun - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  kunlun1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/17 - the current system date.  20:20 - the current system time.  2022 - the current year.  09 - the current month.  17 - the current day of the month.  20 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class kunlun1 {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> Judge=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int a:array){
            set.add(a);
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
        }
        int len=array.length;
        len=len/2;
        int ans=-1;
        for(int a:set){
            if(Judge.get(a)>len){
                ans=a;
                break;
            }
        }
        return ans;
    }
}
