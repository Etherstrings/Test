package BoleGames;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-02-23 14:34 BoleGames - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/23 - the current system date.  14:34 - the current system time.  2023 - the current year.  02 - the current month.  23 - the current day of the month.  14 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num4 {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{2,-1,0,4}));
    }
    public static int maximumSum (int[] arr) {
        // write code here
        // 可以删去子数组的其中一个元素
        // 删除什么呢？
        // 删除复数最大的那个 就是最小的
        List<List<Integer>> t=conList1(arr);
        int ans=Integer.MIN_VALUE;
        for(List<Integer> now:t){
            ans=Math.max(Math.max(now.get(0),now.get(0)-now.get(1)),ans);
        }
        return ans;
    }
    public static List<List<Integer>> conList1(int[] arr){
        //0当前数组的sum 当前最小的数
        List<List<Integer>> ans=new ArrayList<>();
        if(arr==null||arr.length<1){
            return ans;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                List<Integer> temp=new ArrayList<>();
                int sum=0;
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                    min=Math.min(arr[k],min);
                }
                temp.add(sum);
                temp.add(min);
                ans.add(temp);
            }
        }
        return ans;
    }
    public static List<List<Integer>> conList(int[] arr){
        List<List<Integer>> ans=new ArrayList<>();
        if(arr==null||arr.length<1){
            return ans;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                List<Integer> temp=new ArrayList<>();
                for(int k=i;k<=j;k++){
                    temp.add(arr[k]);
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
