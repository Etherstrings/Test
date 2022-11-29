import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-11-17 22:31 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L792 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/17 - the current system date.  22:31 - the current system time.  2022 - the current year.  11 - the current month.  17 - the current day of the month.  22 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L792 {
    public static void main(String[] args) {
        dfs("abc",0);
        for(String now:ans){
            System.out.println(now);
        }
    }

    static List<String> ans=new ArrayList<>();
    static List<Character> Path=new ArrayList<>();
    //回溯拼接所有子串
    static void dfs(String s,int index){
        if(index==s.length()){
            if(Path.size()!=0){
                String t="";
                for(Character a:Path){
                    t+=a;
                }
                ans.add(t);
            }
            return;
        }else {
            if(Path.size()!=0){
                String t="";
                for(Character a:Path){
                    t+=a;
                }
                ans.add(t);
            }
        }
        for(int i=index;i<s.length();i++){
            Character now=s.charAt(i);
            //拼当前位置
            Path.add(now);
            dfs(s,i+1);
            Path.remove(Path.size()-1);
        }
    }

}
