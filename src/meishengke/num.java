package meishengke;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-22 20:51 meishengke - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  20:51 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  20 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String num=in.nextLine();
        String zhengshu="";
        String fen="";
        int index=-1;
        for(int i=0;i<num.length();i++){
            Character now=num.charAt(i);
            if(now=='.'){
                index=i;
                break;
            }
            zhengshu+=now;
        }
        for(int i=index+1;i<num.length();i++){
            fen+=num.charAt(i);
        }
        HashMap<Integer,String> Weishu=new HashMap<>();
        //壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零
        Weishu.put(1,"元");
        Weishu.put(2,"拾");
        Weishu.put(3,"佰");
        Weishu.put(4,"仟");
        Weishu.put(5,"万");
        Weishu.put(6,"拾万");
        Weishu.put(7,"佰万");
        Weishu.put(8,"仟万");
        Weishu.put(9,"亿");
        Weishu.put(10,"拾亿");
        Weishu.put(11,"佰亿");
        Weishu.put(12,"仟亿");
        //壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零
        HashMap<Integer,String> Daxie=new HashMap<>();
        Daxie.put(0,"零");
        Daxie.put(1,"壹");
        Daxie.put(2,"贰");
        Daxie.put(3,"叁");
        Daxie.put(4,"肆");
        Daxie.put(5,"伍");
        Daxie.put(6,"陆");
        Daxie.put(7,"柒");
        Daxie.put(8,"捌");
        Daxie.put(9,"玖");
        //1409 一千四百零九元
        String ans="";
        int size=zhengshu.length();
        for(int i=0;i<zhengshu.length();i++){
            Integer now=Integer.parseInt(zhengshu.charAt(i)+"");
            ans+=Daxie.get(now);
            if(now==0){

            }else {
                ans+=Weishu.get(size);
            }
            size--;
        }
        String fenshu="";

        fenshu+=Daxie.get(Integer.parseInt(fen.charAt(0)+""))+"角";
        fenshu+=Daxie.get(Integer.parseInt(fen.charAt(1)+""))+"分";
        ans+=fenshu;
        System.out.println(ans);
    }
}
