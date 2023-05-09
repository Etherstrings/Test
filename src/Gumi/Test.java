package Gumi;

/**
 * @author Etherstrings
 * @create 2023-03-25 14:14 Gumi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Test - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/25 - the current system date.  14:14 - the current system time.  2023 - the current year.  03 - the current month.  25 - the current day of the month.  14 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class Test {


    public static void main(String[] args) {
        String str="JAVA is great";
        String res=str.substring(0,4)+str.charAt(7)+str.substring(5,7);
        System.out.println(res);
        String s1="abc";
        String s2="abc";
        String s3=new String("abc");
        System.out.println(s1==s2);
        System.out.println(s1==s3);

        int[] arr1=new int[]{1,2};
        int[] arr2=new int[]{1,2};
        System.out.println(arr2==arr1);
        System.out.println(arr1.equals(arr2));
    }
}
