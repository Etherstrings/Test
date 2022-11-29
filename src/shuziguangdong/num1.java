package shuziguangdong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-11-26 19:12 shuziguangdong - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/26 - the current system date.  19:12 - the current system time.  2022 - the current year.  11 - the current month.  26 - the current day of the month.  19 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1=in.nextLine();
            line1=line1.substring(1,line1.length()-1);
            String[] strs=line1.split(",");
            int[] nums=new int[strs.length];
            for(int i=0;i< strs.length;i++){
                nums[i]=Integer.parseInt(strs[i]);
            }
            System.out.println(findlong(nums));
        }
    }

    static int findlong(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int ans=0;
        for(int num:nums){
            if(map.containsKey(num-1)){
                ans=Math.max(ans,map.get(num)+map.get(num-1));
            }
        }
        return ans;
    }
}
