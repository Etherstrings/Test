package xiecheng;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-18 19:03 xiecheng - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/18 - the current system date.  19:03 - the current system time.  2022 - the current year.  10 - the current month.  18 - the current day of the month.  19 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int k=in.nextInt();
        String numstr=num+"";
        String ans="";
        //k为翻转前几个
        for(int i=k-1;i>=0;i--){
            if(i==k-1){
                if(numstr.charAt(i)=='0'){
                    continue;
                }else {
                    ans+=numstr.charAt(i);
                    continue;
                }
            }
            ans+=numstr.charAt(i);
        }
        for(int i=k;i<numstr.length();i++){
            ans+=numstr.charAt(i);
        }
        System.out.println(ans);
    }
}
