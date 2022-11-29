import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-09-02 16:43 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Main - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/2 - the current system date.  16:43 - the current system time.  2022 - the current year.  09 - the current month.  02 - the current day of the month.  16 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            if(str.indexOf("<")==-1){
                System.out.print("NO");
            }
            if(str.indexOf("<")!=0){
                System.out.print("NO");
            }
            List<String> temp=new ArrayList<>();
            while(str.indexOf("<")!=-1||str.indexOf(">")!=-1){
                String substring = str.substring(str.indexOf("<")+1, str.indexOf(">"));
                temp.add(substring);
                str=str.substring(0,str.indexOf("<")+1)+str.substring(str.indexOf(">"),str.length());
            }
            for(String a:temp){
                if(a==null){
                    System.out.print("NO");
                    break;
                }
                if(a.indexOf("/")!=0){
                    System.out.print("NO");
                    break;
                }
            }
            System.out.print("YES");
        }
    }


}
