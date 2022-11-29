package meidi;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-14 22:46 meidi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meidi1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  22:46 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  22 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meidi1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        List<String> Allstr=new ArrayList<>();
        while(in.hasNextLine()){
            String[] strs=in.nextLine().split(" ");
            for(String a:strs){
                Allstr.add(a);
            }

            HashMap<String,Integer> Judge=new HashMap<>();
            Set<String> Panduan=new HashSet<>();
            for(String temp:Allstr){
                Panduan.add(temp);
                if(Judge.containsKey(temp)){
                    Judge.put(temp,Judge.get(temp)+1);
                }else {
                    Judge.put(temp,1);
                }
            }
            boolean Flag=false;
            for(String now:Panduan){
                if(Judge.get(now)>=2){
                    Flag=true;
                    break;
                }
            }
            System.out.println(Flag);
        }

    }
}
