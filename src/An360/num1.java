package An360;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-18 15:01 An360 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  15:01 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  15 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        int[] nums=new int[N];
        String[] words=in.nextLine().split(" ");
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(words[i]);
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        int ans=0;
        for(int key:map.keySet()){
            if(map.get(key)==1){
                continue;
            }else {
                int v=map.get(key);
                ans+=v-1;
            }
        }
        System.out.println(ans);
    }
}
