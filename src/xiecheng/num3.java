package xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-18 19:15 xiecheng - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/18 - the current system date.  19:15 - the current system time.  2022 - the current year.  10 - the current month.  18 - the current day of the month.  19 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            String[] nums=in.nextLine().split(" ");
            ans.add(getans(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]),Integer.parseInt(nums[2]),Integer.parseInt(nums[3])));
        }
        for(String now:ans){
            System.out.println(now);
        }
    }

    public static String getans(int a,int b,int l,int r){
        if(a>b){
            return "-1";
        }
        if(a==b){
            return "0 0";
        }
        int cha=b-a;
        if(l==r){
            if(cha%l==0){
                int t=cha%l;
                return t+" "+t;
            }else {
                return "-1";
            }
        }
        //贪心 每次都加最小的
        int now=a;
        int max=0;
        if(cha%l==0){
            //可以每一次都加小的
            max=cha/l;
        }else {

        }
        return "";
    }
}
