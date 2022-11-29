package Mianshi;

/**
 * @author Etherstrings
 * @create 2022-09-22 14:01 Mianshi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  mian - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  14:01 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  14 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class mian {
    public static void main(String[] args) {
        //n-10
        //2空瓶-一瓶水
        //3瓶盖-一瓶水
        int size=0;
        int[] nums=new int[3];
        nums[0]=10;
        nums[1]=0;
        nums[2]=0;
        while(nums[0]!=0){
            size+=nums[0];
            nums[1]+=nums[0];
            nums[2]+=nums[0];
            nums[0]=0;
            //
            nums[0]+=nums[1]/2;
            nums[1]=nums[1]%2;
            //
            nums[0]+=nums[2]/3;
            nums[2]=nums[2]%3;
        }
        System.out.println(size);

    }
}
