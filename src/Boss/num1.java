package Boss;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-12 21:55 Boss - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/12 - the current system date.  21:55 - the current system time.  2022 - the current year.  09 - the current month.  12 - the current day of the month.  21 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int a=in.nextInt();
            int b=in.nextInt();
            if(a==0||b==0){
                System.out.println(0);
                break;
            }
            if(a==b){
                System.out.println(a);
                break;
            }
            if(a%b==0){
                System.out.println(a);
                break;
            }
            if(b%a==0){
                System.out.println(b);
                break;
            }
            int min=Math.min(a,b);
            int max=Math.max(a,b);
            //a*b 除以最大公因数
            int ans=(a*b)/getgid(a,b);
            System.out.println(ans);
        }

    }

    static  int getgid(int a,int b){
        while(b!=0){
            int r=b;
            b=a%b;
            a=r;
        }
        return a;
    }
}
