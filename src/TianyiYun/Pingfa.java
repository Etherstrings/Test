package TianyiYun;

/**
 * @author Etherstrings
 * @create 2022-10-06 14:55 TianyiYun - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Pingfa - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/6 - the current system date.  14:55 - the current system time.  2022 - the current year.  10 - the current month.  06 - the current day of the month.  14 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class Pingfa {
    public int sqrt (int x) {
        // write code here
        if(x<=1){
            return x;
        }
        //二分法
        long left=0;
        long right=x;
        long mid=-1l;
        while(left<right){
            mid=left+(right-left)/2;
            if(mid*mid<=x&&(mid+1)*(mid+1)>x){
                return (int)mid;
            }else if(mid*mid>x){
                right=mid;
            }else {
                left=mid;
            }
        }
        return (int)mid;
    }
}
