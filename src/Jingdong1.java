import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-09 10:17 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Jingdong1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/9 - the current system date.  10:17 - the current system time.  2022 - the current year.  09 - the current month.  09 - the current day of the month.  10 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Jingdong1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String temp=in.nextLine();
            //思路--挨个取 每次取2
            //比较进行拼接
            String second="";
            int ans=0;
            while(temp.length()!=0){
                //当前temp的大小
                //可以取3
                if(temp.length()>=3){
                    String now=temp.substring(0,3);
                    if(now.charAt(0)==now.charAt(1)){
                        //前两个相同
                        ans++;
                        now=now.substring(0,2);
                        temp=temp.replaceFirst(now,"");
                        continue;
                    }
                    if(now.charAt(1)==now.charAt(2)){
                        //后两个相同
                        ans++;
                        now=now.substring(1,3);
                        temp=temp.replaceFirst(now,"");
                        continue;
                    }
                    //三个都不相同


                }else {
                    if(temp.length()==1){
                        temp="";
                    }else {
                        break;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
