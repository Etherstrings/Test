package ali;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-22 9:28 ali - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  moni2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  9:28 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  09 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class moni2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

            String line1=in.nextLine();
            long target=Long.parseLong(in.nextLine());
            if(line1.length()<(target+"").length()){
                System.out.println(0);
            }else {
                int ans=0;
                for(int i=0;i<line1.length();i++){
                    for(int j=i+1;j<line1.length()+1;j++){
                        String now=line1.substring(i,j);
                        if(Long.parseLong(now)<target){
                            ans++;
                        }else {
                            break;
                        }
                    }
                }
                System.out.println(ans);
            }


    }
}
