package Leetcode.week333;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-02-19 10:36 Leetcode.week333 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/19 - the current system date.  10:36 - the current system time.  2023 - the current year.  02 - the current month.  19 - the current day of the month.  10 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> keys=new HashSet<>();
        for(int[] num:nums1){
            map.put(num[0],num[1]);
            keys.add(num[0]);
        }
        for(int[] num:nums2){
            if(map.containsKey(num[0])){
                map.put(num[0],map.get(num[0])+num[1]);
            }else {
                map.put(num[0],num[1]);
            }
            keys.add(num[0]);
        }
        List<Integer> klist=new ArrayList<>();
        for(Integer key:keys){
            klist.add(key);
        }
        Collections.sort(klist);
        int[][] ans=new int[klist.size()][2];
        for(int i=0;i<klist.size();i++){
            ans[i][0]=klist.get(i);
            ans[i][1]=map.get(klist.get(i));
        }
        return ans;
    }
}
