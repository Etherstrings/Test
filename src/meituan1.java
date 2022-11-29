import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-03 10:03 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  10:03 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  10 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meituan1 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int a=in.nextInt();
            int b=in.nextInt();
            int ans=0;
            if(a>b){
                //前提是小美比b大
                int temp=a-b;
                if(temp>=2){
                    //已经满足2
                    //这时候需要满足1
                    if(a<11){
                        ans+=(11-a);
                    }
                }else {
                    //不满足2
                    ans+=(2-temp);
                    //这时候需要满足1
                    if(a<11){
                        ans+=(11-a);
                    }
                }
            }else if(a<b){
                //小美比b小
                int temp=b-a;
                a+=(temp+2);
                ans+=(temp+2);
                if(a<11){
                    ans+=(11-a);
                }
            }else {
                //小美==b
                ans+=2;
                a+=2;
                if(a<11){
                    ans+=(11-a);
                }
            }
            System.out.print(ans);
        }
    }
}
