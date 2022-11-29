package TianyiYun;

import java.util.ArrayList;

/**
 * @author Etherstrings
 * @create 2022-10-06 15:00 TianyiYun - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  exceptmyself - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/6 - the current system date.  15:00 - the current system time.  2022 - the current year.  10 - the current month.  06 - the current day of the month.  15 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class exceptmyself {
    public ArrayList<Integer> timesExceptSelf (ArrayList<Integer> nums) {
        // write code here
        ArrayList<Integer> ans=new ArrayList<>();
        int[] t=new int[nums.size()];
        int temp=1;
        for(int i=0;i<nums.size();i++){
            t[i]=temp;
            temp=temp*nums.get(i);
        }
        temp=1;
        for(int i=nums.size()-1;i>=0;i--){
            t[i]*=temp;
            temp*=nums.get(i);
        }
        for(int a:t){
            ans.add(a);
        }
        return ans;
    }
}
