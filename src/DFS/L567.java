package DFS;

import java.util.LinkedList;

/**
 * @author Etherstrings
 * @create 2023-02-25 13:39 DFS - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L567 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/25 - the current system date.  13:39 - the current system time.  2023 - the current year.  02 - the current month.  25 - the current day of the month.  13 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidboaoo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        //s1的所有排列？
        boolean[] used=new boolean[s1.length()];
        DFS(s1,used,s2);
        return flag;
    }

    static LinkedList<Character> Path=new LinkedList<>();


    static boolean flag=false;



    public static void DFS(String s1,boolean[] used,String s2){
        if(flag==true){
            return;
        }
        if(Path.size()==s1.length()){
            Object[] c = Path.toArray();
            String temp="";
            for(Object n:c){
                temp+=n;
            }
            if(s2.indexOf(temp)!=-1){
                flag=true;
            }
            return;
        }

        for(int i=0;i<s1.length();i++){
            if(used[i]){
                continue;
            }
            Path.offer(s1.charAt(i));
            used[i]=true;
            DFS(s1,used,s2);
            used[i]=false;
            Path.removeLast();
        }
    }
}
