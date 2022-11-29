package Duxiaoman;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-15 18:45 Duxiaoman - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Du1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/15 - the current system date.  18:45 - the current system time.  2022 - the current year.  09 - the current month.  15 - the current day of the month.  18 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Du1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int n=Integer.parseInt(in.nextLine());
            String[] strs=new String[n];
            for(int i=0;i<n;i++){
                strs[i]=in.nextLine();
            }
            int[] ans=new int[n];
            for(int i=0;i<strs.length;i++){
                String now=strs[i];
                ans[i]=StrToInt(now);
            }
            int big=Integer.MIN_VALUE;
            for(int a:ans){
                big=Math.max(big,a);
            }
            System.out.println(big);
        }
    }

    static int StrToInt(String now){
        HashMap<Character,Integer> Judge=new HashMap<>();
        HashSet<Character> Set=new HashSet<>();
        for(Character a:now.toCharArray()){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else {
                Judge.put(a,1);
            }
            Set.add(a);
        }
        int min=Integer.MAX_VALUE;
        int Max=0;
        for(Character a:Set){
            min=Math.min(Judge.get(a),min);
            Max=Math.max(Judge.get(a),Max);
        }
        return Max-min;
    }
}
