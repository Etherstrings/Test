package ShangYou;

/**
 * @author Etherstrings
 * @create 2023-03-17 19:13 ShangYou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Example - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/17 - the current system date.  19:13 - the current system time.  2023 - the current year.  03 - the current month.  17 - the current day of the month.  19 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class Example {
    String str=new String("some");
    char[] ch={'a','b','c'};

    public static void main(String[] args) {
        Example ex=new Example();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str+" "+ex.ch);

    }
    public void change(String str,char ch[]){
        str="foo";
        ch[0]='t';
    }
}
