package MihaYou;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-19 21:16 MihaYou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  21:16 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  21 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    //N
    //S
    //T
    //S 'mhy'
    //mmhhyy
    //abcmhy
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            List<String[]> temp=new ArrayList<>();
            int N=Integer.parseInt(in.nextLine());
            for(int i=0;i<N;i++){
                String s=in.nextLine();
                String t=in.nextLine();
                String[] ss=new String[]{s,t};
                temp.add(ss);
            }
            List<Boolean> geta = geta(temp);
            for(boolean n:geta){
                if(n){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }

    public static List<Boolean> geta(List<String[]> temp){
        List<Boolean> ans=new ArrayList<>();
        for(String[] strs:temp){
            String s=strs[0];
            String t=strs[1];
            ans.add(canTransform(s,t));
        }
        return ans;
    }

    public static boolean canTransform(String s, String t) {
        Set<Character> s1=new HashSet<>();
        Set<Character> t1=new HashSet<>();
        HashMap<Character,Integer> sm=new HashMap<>();
        HashMap<Character,Integer> st=new HashMap<>();
        for(char n:s.toCharArray()){
            s1.add(n);
            if(sm.containsKey(n)){
                sm.put(n,sm.get(n));
            }else {
                sm.put(n,1);
            }
        }
        s1.add('m');
        s1.add('h');
        s1.add('y');
        for(char n:t.toCharArray()){
            t1.add(n);
            if(st.containsKey(n)){
                st.put(n,st.get(n));
            }else {
                st.put(n,1);
            }
        }
        for(Character n:t1){
            if(!s1.contains(n)){
                return false;
            }
        }
        if(!sm.containsKey('m')){
            sm.put('m',1);
        }
        if(!sm.containsKey('h')){
            sm.put('h',1);
        }        if(!sm.containsKey('y')){
            sm.put('y',1);
        }
        for(char key:st.keySet()){
            if(key=='m'||key=='h'||key=='y'){
                continue;
            }
            if(st.get(key)!=sm.get(key)){
                return false;
            }
        }
        //m2 h1 y3
        //m1 h2 y4
        if(st.containsKey('m')&&st.containsKey('h')&&st.containsKey('y')){
            int m=st.get('m');
            int h=st.get('h');
            int y=st.get('y');
            if(Math.abs(m-sm.get('m'))==Math.abs(h-sm.get('h'))&&Math.abs(h-sm.get('h'))==Math.abs(y-sm.get('y'))){
                return true;
            }else {
                return false;
            }
        }else {
            int m=0;
            int h=0;
            int y=0;
            if(st.containsKey('m')){
                m=st.get('m');
            }
            if(st.containsKey('h')){
                h=st.get('h');
            }
            if(st.containsKey('y')){
                y=st.get('y');
            }
            if(Math.abs(m-sm.get('m'))==Math.abs(h-sm.get('h'))&&Math.abs(h-sm.get('h'))==Math.abs(y-sm.get('y'))){
                return true;
            }else {
                return false;
            }
        }
    }

}
