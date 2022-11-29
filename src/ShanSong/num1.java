package ShanSong;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-25 15:54 ShanSong - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/25 - the current system date.  15:54 - the current system time.  2022 - the current year.  09 - the current month.  25 - the current day of the month.  15 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        /**
         *         String s;
         *         String basic="";
         *         while(true) {
         *             if ((s = in.nextLine()).equals("")) {
         *                 break;
         *             }
         *             basic += s;
         *         }
         */

        String[] line=in.nextLine().split(";");
        if(line[0].length()==2&&line[1].length()!=2){
            //A没有数据
            System.out.println(line[1]);
        }else if(line[0].length()!=2&&line[1].length()==2){
            //B没有数据
            System.out.println(line[0]);
        }else {
            line[0]=line[0].substring(1,line[0].length()-1);
            line[1]=line[1].substring(1,line[1].length()-1);
            String[] str1=null;
            String[] str2=null;
            if(line[0].indexOf(",")==-1){
                str1=new String[1];
                str1[0]=line[0];
            }else {
                str1=line[0].split(",");
            }

            if(line[1].indexOf(",")==-1){
                str2=new String[1];
                str2[0]=line[1];
            }else {
                str2=line[1].split(",");
            }
            Set<Integer> All=new HashSet<>();
            Set<Integer> setA=new HashSet<>();
            Set<Integer> setB=new HashSet<>();
            for(String a:str1){
                int now=Integer.parseInt(a);
                setA.add(now);
                All.add(now);
            }
            for(String b:str2){
                int now=Integer.parseInt(b);
                setB.add(now);
                All.add(now);
            }
            List<Integer> ans=new ArrayList<>();
            for(Integer a:All){
                if(setA.contains(a)&&setB.contains(a)){
                    continue;
                }
                ans.add(a);
            }
            String t="[";
            if(ans.size()==0){
                t+="]";
            }else if(ans.size()==1){
                t+=ans.get(0);
                t+="]";
            }else {
                Collections.sort(ans);
                for(int i=0;i< ans.size();i++){
                    if(i== ans.size()-1){
                        t+=ans.get(i);
                        continue;
                    }
                    t+=ans.get(i);
                    t+=",";
                }
                t+="]";
            }



            System.out.println(t);

        }


    }

    public static int[] get(int[] A,int[] B){
        Set<Integer> All=new HashSet<>();
        Set<Integer> setA=new HashSet<>();
        Set<Integer> setB=new HashSet<>();
        for(Integer a:A){
            int now=a;
            setA.add(now);
            All.add(now);
        }
        for(Integer a:B){
            int now=a;
            setB.add(now);
            All.add(now);
        }
        List<Integer> ans=new ArrayList<>();
        for(Integer a:All){
            if(setA.contains(a)&&setB.contains(a)){
                continue;
            }
            ans.add(a);
        }
        Collections.sort(ans);
        int[] t=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            t[i]=ans.get(i);
        }
        return t;
    }
}
