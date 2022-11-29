package yuewen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-11-01 19:34 yuewen - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/1 - the current system date.  19:34 - the current system time.  2022 - the current year.  11 - the current month.  01 - the current day of the month.  19 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {

    }
    public static int[] merge (int[] nums1, int m, int[] nums2, int n) {
        // write code here
        List<Integer> ans=new ArrayList<>();
        for(int a:nums1){
            if(a==0){
                continue;
            }
            ans.add(a);
        }
        for(int b:nums2){
            ans.add(b);
        }
        Collections.sort(ans);
        int[] t=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            t[i]=ans.get(i);
        }
        return t;
    }
}
