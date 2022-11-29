package tencent;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-16 20:54 tencent - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/16 - the current system date.  20:54 - the current system time.  2022 - the current year.  10 - the current month.  16 - the current day of the month.  20 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        int L=Integer.parseInt(line[0]);
        int R=Integer.parseInt(line[1]);
        String str="1";
        while(str.length()<=Integer.MAX_VALUE){
            str=trans(str);
        }
        int sum=0;
        for(int i=L-1;i<R;i++){
            if(str.charAt(i)=='1'){
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static String trans(String str){
        StringBuffer sb=new StringBuffer(str);
        for(char a:str.toCharArray()){
            if(a=='1'){
                sb.append("0");
            }else {
                sb.append("1");
            }
        }
        return sb.toString();
    }
}
