package youka;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-10-11 19:22 youka - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/11 - the current system date.  19:22 - the current system time.  2022 - the current year.  10 - the current month.  11 - the current day of the month.  19 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {

    }

    public int halfQuestions (int[] questions) {
        // write code here
        if(questions.length==0){
            return 0;
        }
        int stu=questions.length/4;
        int choose=stu*2;
        Set<Integer> judge=new HashSet<>();
        for(int num:questions){
            judge.add(num);
        }
        if(judge.size()>choose){
            return choose;
        }else if(judge.size()==choose){
            return choose;
        }else {
            return judge.size();
        }
    }
}
