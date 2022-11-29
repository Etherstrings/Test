package Tuyou;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-11-15 14:53 Tuyou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/15 - the current system date.  14:53 - the current system time.  2022 - the current year.  11 - the current month.  15 - the current day of the month.  14 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        System.out.println(func1(1));
    }
    public static float func1 (int i) {
        // write code here
        if(i==1){
            return 1f/2f;
        }
        float[] ans=new float[i+1];
        ans[0]=0f;
        ans[1]=(1f/2f);
        ans[2]=(1f/4f);
        //从3开始
        //此时  加的为0.5
        float add=ans[1];
        for(int k=3;k<=i;k++){
            float now=add+ans[k-1];

            if(now>=1){
                //需要进入下一个阶段
                //比如我现在k为4
                ans[k]=add/2/2;
                add=add/2;
            }else {
                ans[k]=now;
            }


        }
        return ans[i];
    }
}
