package ShangYou;

/**
 * @author Etherstrings
 * @create 2023-03-17 19:12 ShangYou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Test - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/17 - the current system date.  19:12 - the current system time.  2023 - the current year.  03 - the current month.  17 - the current day of the month.  19 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class Test {
    public static void main(String[] args) {
        int i=0;int s=0;
        do{
            if(i%2==0){
                i++;
                continue;
            }
            i++;
            s=s+i;
        }while(i<7);
        System.out.println(s);
    }
}
