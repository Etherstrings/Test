package OuKe;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-09-16 14:34 OuKe - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  OuKe2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/16 - the current system date.  14:34 - the current system time.  2022 - the current year.  09 - the current month.  16 - the current day of the month.  14 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class OuKe2 {
    public boolean wordPattern (String pattern, String str) {
        // write code here
        // 字符串转换为字母
        // abba - 1221
        // 表示这是出现的第几个新字母？
        return tarns(pattern).equals(tarns(str));

    }

    static String tarns(String str){
        String temp="";
        HashMap<String,Integer> Judge=new HashMap<>();
        if(str.indexOf(" ")==-1){
            //不含有空格--模式串
            for(Character a:str.toCharArray()){
                String now=a+"";
                if(Judge.containsKey(now)){
                    temp+=Judge.get(now);
                }else {
                    //第几次出现？
                    //现在size为0 那就是第一个新出现的
                    //size为1 那就是第二个新出现的
                    Judge.put(now,Judge.size()+1);
                    temp+=Judge.get(now);
                }
            }
        }else {
            String[] strs=str.split(" ");
            for(String a:strs){
                if(Judge.containsKey(a)){
                    temp+=Judge.get(a);
                }else {
                    Judge.put(a,Judge.size()+1);
                    temp+=Judge.get(a);
                }
            }
        }
        return temp;
    }

}
