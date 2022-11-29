package ShanSong;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-25 16:34 ShanSong - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/25 - the current system date.  16:34 - the current system time.  2022 - the current year.  09 - the current month.  25 - the current day of the month.  16 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String now="";
        String line1="";
            while(!now.equals("]")){
                now=in.next();
                line1+=now;
            }
            line1+=now;
            line1+="]";
            String uselese=in.next();
            now="";
            String line2="";
            while(!now.equals("]")){
                now=in.next();
                line2+=now;
            }
            line2+=now;
            line2+="]";
            System.out.println(line1);
            System.out.println(line2);


    }
}
