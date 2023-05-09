package meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2023-03-18 10:38 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan6 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  10:38 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  10 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class meituan6 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] words=in.nextLine().split(" ");
        int N=Integer.parseInt(words[0]);
        int k=Integer.parseInt(words[1]);
        int[] nums=new int[N];
        String[] line2=in.nextLine().split(" ");
        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(line2[i]);
        }
        System.out.println(getans(nums,k));
    }
    public static int getans(int[] nums,int k){
        int ans=-1;
        for(int i=0;i<nums.length-1;i++){
            Set<Integer> temp=new HashSet<>();
            temp.add(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                if(temp.size()>k){
                    ans=Math.max(ans,j-1-i);
                    break;
                }
                temp.add(nums[j]);
            }
        }
        return ans;
    }
}
