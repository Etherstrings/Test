package cehui;

/**
 * @author Etherstrings
 * @create 2022-09-24 10:03 cehui - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/24 - the current system date.  10:03 - the current system time.  2022 - the current year.  09 - the current month.  24 - the current day of the month.  10 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        System.out.println(reverseChange("abcde","cdeab"));
        System.out.println(reverseChange("abcde","abced"));
    }
    //核心代码模式
    public static boolean reverseChange(String A,String B){
        if(A.equals(B)){
            return true;
        }
        if(A.length()==1&&B.length()==1){
            return A.equals(B);
        }
        if(A.length()<B.length()){
            return false;
        }
        //A多少次循环会变回自己？
        //abc-最多三次
        //abdc--最多4次
        boolean flag=false;
        for(int i=0;i<A.length();i++){
            //循环 len次
            A=A.substring(1,A.length())+A.substring(0,1);
            if(A.equals(B)){
                flag=true;
                break;
            }
        }
        return flag;

    }
}
