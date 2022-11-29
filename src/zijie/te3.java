package zijie;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-18 11:02 zijie - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  te3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/18 - the current system date.  11:02 - the current system time.  2022 - the current year.  09 - the current month.  18 - the current day of the month.  11 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class te3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String lie1=in.nextLine();
            //dp
            int[] nums=new int[lie1.length()];
            for(int i=0;i<lie1.length();i++){
                nums[i]=Integer.parseInt(lie1.charAt(i)+"");
            }
            int sisze=0;
            /**
            for(int i=0;i<nums.length;i++){
                int j=i+1;
                while(j<nums.length&&nums[j-1]!=nums[j]){
                    j++;
                }
                sisze=Math.max(sisze,j-i);
                i=j-i;
            }
             **/
            int[] dp=new int[nums.length];
            dp[0]=1;
            for(int i=1;i<nums.length;i++){
                if(nums[i]!=nums[i-1]){
                    dp[i]=dp[i-1]+1;
                }else {
                    dp[i]=1;
                }
            }
            for(int a:dp){
                sisze=Math.max(sisze,a);
            }
            System.out.println(sisze);
        }
    }
}
