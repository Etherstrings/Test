package MihaYou;

/**
 * @author Etherstrings
 * @create 2023-03-19 21:08 MihaYou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  TTest - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  21:08 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  21 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class TTest {
    public static void main(String[] args) {
        String t="abbcc";
        char[] chars = t.toCharArray();
        System.out.println(countSegments(chars));
    }
    public static int countSegments(char[] s) {
        char last=s[0];
        int index=0;
        int sum=0;
        for(int i=1;i<s.length;i++){
            char now=s[i];
            if(i==s.length-1){
                if(now==last){
                    int len=i-index+1;
                    if(len>=2){
                        sum++;
                    }
                }else {
                    int len=i-index;
                    if(len>=2){
                        sum++;
                    }
                    index=i;
                    last=now;
                }
                continue;
            }
            if(now!=last){
                int len=i-index;
                if(len>=2){
                    sum++;
                }
                index=i;
                last=now;
            }else {
                continue;
            }
        }
        return sum;
    }
}
