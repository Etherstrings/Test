package Leetcode.week334;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-02-26 10:29 Leetcode.week334 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/26 - the current system date.  10:29 - the current system time.  2023 - the current year.  02 - the current month.  26 - the current day of the month.  10 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        //System.out.println(maxNumOfMarkedIndices(new int[]{9,2,5,4}));
        System.out.println(maxNumOfMarkedIndices(new int[]{42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40}));
    }
    public static int maxNumOfMarkedIndices(int[] nums) {
        //当前的最大值 用小值中的最大值来碰撞
        List<Integer> list=new ArrayList<>();

        for(int i:nums){
            list.add(i);
        }
        if(list.size()==1){
            return 0;
        }
        if(list.size()==0){
            return 0;
        }
        Collections.sort(list);
        Collections.reverse(list);
        int ans=0;
        boolean[] used=new boolean[list.size()];
        for(int i=0;i<nums.length-1;i++){
            if(used[i]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(used[j]){
                    continue;
                }
                if(list.get(j)*2<=list.get(i)){
                    used[i]=true;
                    used[j]=true;
                    ans+=2;
                    break;
                }
            }
        }

        return ans;
    }


}
