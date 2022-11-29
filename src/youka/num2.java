package youka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-10-11 19:26 youka - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/11 - the current system date.  19:26 - the current system time.  2022 - the current year.  10 - the current month.  11 - the current day of the month.  19 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        String now=ambiguousCoordinates("123");
        System.out.println(now);
    }

    public static String ambiguousCoordinates (String s) {
        // write code here
        List<String> result=new ArrayList<>();
        String left="(";
        left+=s;
        left+=")";
        s=left;
        int n=s.length();
        for(int i=2;i<n-1;i++){
            String temp1=s.substring(1,i);
            String temp2=s.substring(i,s.length()-1);
            List<String> list1=helper(temp1);
            List<String> list2=helper(temp2);
            for(String now1:list1){
                for(String now2:list2){
                    result.add(now1+","+now2);
                }
            }
        }
        /**
         *

        Comparator<String> com=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer num1=Integer.parseInt(o1.substring(0,o1.indexOf(",")));
                Integer num2=Integer.parseInt(o2.substring(0,o2.indexOf(",")));
                return num1-num2;
            }
        };
         */
        Collections.sort(result);
        String ans="";
        for(int i=0;i<result.size();i++){
            if(i== result.size()-1){
                ans+=result.get(i);
                break;
            }
            ans+=result.get(i);
            ans+=",";
        }
        return ans;
    }


    public static List<String> helper(String s){
        List<String> list=new ArrayList<>();
        if(s.length()>1&&s.charAt(0)=='0'){
            if(s.endsWith("0")){
                return list;
            }
            list.add("0."+s.substring(1));
            return list;
        }
        list.add(s);
        if(s.endsWith("0")){
            return list;
        }
        for(int i=1;i<s.length();i++){
            list.add(s.substring(0,i)+"."+s.substring(i));
        }
        return list;
    }

}
