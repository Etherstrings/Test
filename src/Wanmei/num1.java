package Wanmei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-12 11:19 Wanmei - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  11:19 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  11 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    // skills
    // target
    // 技能可以重复使用
    public static void main(String[] args) {
        int[] skills={1,5,19};
        int target=20;
        System.out.println(getans(target,skills));
    }

    public static int getans(int target,int[] skills){
        ans=new ArrayList<>();
        back(0,target,skills,0);
        if(ans.size()==0){
            return -1;
        }
        Collections.sort(ans);
        return ans.get(0);
    }
    public static List<Integer> ans;
    public static void back(int sum,int target,int[] skills,int used){
        if(sum>=target){
            if(sum==target){
                ans.add(used);
            }
            return;
        }
        for(int i=0;i<skills.length;i++){
            sum+=skills[i];
            used+=1;
            back(sum,target,skills,used);
            sum-=skills[i];
            used-=1;
        }
    }
}
