package Jidu;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-31 15:15 Jidu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/31 - the current system date.  15:15 - the current system time.  2023 - the current year.  03 - the current month.  31 - the current day of the month.  15 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] words=in.nextLine().split(",");
        boolean[] used=new boolean[words.length];
        Arrays.sort(words);

    }

    /**
     * public static void main(String[] args) {
     *         Scanner in=new Scanner(System.in);
     *         String[] words=in.nextLine().split(",");
     *         Arrays.sort(words);
     *         String input=in.nextLine();
     *         List<Integer> temp=new ArrayList<>();
     *         for(int i=0;i<words.length;i++){
     *             if(input.contains(words[i])){
     *                 temp.add(i);
     *             }
     *         }
     *         for(int i=0;i<temp.size();i++){
     *             if(i==temp.size()-1){
     *                 System.out.print(words[temp.get(i)]);
     *             }else {
     *                 System.out.print(words[temp.get(i)]+",");
     *             }
     *         }
     *     }
     * @param
     */


    public static String[] parseWords(String[] words,String input){
        List<String> ans=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(String now:words){
            if(input.contains(now)){
                set.add(now);
            }
        }
        if(set.size()==0){
            return null;
        }
        for(String s:set){
            ans.add(s);
        }
        Collections.sort(ans);
        String[] t=new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            t[i]=ans.get(i);
        }
        return t;
    }
}
