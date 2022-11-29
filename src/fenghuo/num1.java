package fenghuo;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-19 10:45 fenghuo - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/19 - the current system date.  10:45 - the current system time.  2022 - the current year.  09 - the current month.  19 - the current day of the month.  10 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] nums=in.nextLine().split(" ");
            int a=Integer.parseInt(nums[0]);
            int b=Integer.parseInt(nums[1]);
            int c=Integer.parseInt(nums[2]);
            int sum=a+b;
            int target=-1;
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<=sum;i++){
                int na=i;
                int nb=sum-i;
                int temp=na/c+nb/c;
                target=Math.max(temp,target);
            }
            for(int i=0;i<=sum;i++){
                int na=i;
                int nb=sum-i;
                int temp=na/c+nb/c;
                if(temp==target){
                    ans=Math.min(Math.abs(na-a)+Math.abs(nb-b),ans);
                }
            }
            System.out.println(ans);
        }
    }
}
