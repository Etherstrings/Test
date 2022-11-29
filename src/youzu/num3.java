package youzu;

import java.util.ArrayList;

/**
 * @author Etherstrings
 * @create 2022-09-21 22:58 youzu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/21 - the current system date.  22:58 - the current system time.  2022 - the current year.  09 - the current month.  21 - the current day of the month.  22 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public int Trap (ArrayList<Integer> height) {
        // write code here
        // 接雨水
        //1.按照每一列来算
        int sum=0;
        for(int i=1;i<height.size()-1;i++){
            //每一列记录左侧最大值
            int left=-1;
            //右边最大值
            int right=1;
            int now=height.get(i);
            for(int j=0;j<i;j++){
                left=Math.max(left,height.get(j));
            }
            for(int j=i+1;j<height.size();j++){
                right=Math.max(right,height.get(j));
            }
            //当前列存的值
            int h = Math.min(left, right) - height.get(i);
            if(h>0){
                sum+=h;
            }
        }
        return sum;
    }
    public int trap(int[] height) {
        //1.按照每一列来算
        int sum=0;
        for(int i=1;i<height.length-1;i++){
            //每一列记录左侧最大值
            int left=-1;
            //右边最大值
            int right=1;
            int now=height[i];
            for(int j=0;j<i;j++){
                left=Math.max(left,height[j]);
            }
            for(int j=i+1;j<height.length;j++){
                right=Math.max(right,height[j]);
            }
            //当前列存的值
            int h = Math.min(left, right) - height[i];
            if(h>0){
                sum+=h;
            }
        }
        return sum;
    }
}
