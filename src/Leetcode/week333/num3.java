package Leetcode.week333;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-02-19 10:57 Leetcode.week333 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/19 - the current system date.  10:57 - the current system time.  2023 - the current year.  02 - the current month.  19 - the current day of the month.  10 - the current hour.  57 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(squareFreeSubsets(nums));
        System.out.println(Show);
    }
    public static int squareFreeSubsets(int[] nums) {
        DFS(0,nums);
        int base = 1000000007;
        return (int)Result%base;
    }
    public static LinkedList<Integer> Path=new LinkedList<>();
    public static long Result=0;
    public static List<List<Integer>> Show=new ArrayList<>();
    public static void DFS(int startindex,int[] nums){
        //如果当前的已经是了 那需要return吗？
        if(isvaild(Path)){
            Show.add(new ArrayList<>(Path));
            Result++;
        }
        if(startindex>=nums.length){
            return;
        }

        for(int i=startindex;i<nums.length;i++){



            Path.add(nums[i]);
            DFS(i+1,nums);
            Path.removeLast();




        }

    }

    public static boolean isvaild(LinkedList<Integer> Path){
        if(Path.isEmpty()){
            return false;
        }

        ArrayList<Integer> integers = new ArrayList<>(Path);
        Long temp=1l;
        for(int now:integers){
            temp*=now;
        }
        if(temp==1){
            return true;
        }
        boolean flag=true;
        for(long i=2;i<=Math.pow(temp,2);i++){
            if(temp%(i*i)==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
