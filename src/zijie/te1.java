package zijie;

import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author Etherstrings
 * @create 2022-09-18 10:02 zijie - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  te1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/18 - the current system date.  10:02 - the current system time.  2022 - the current year.  09 - the current month.  18 - the current day of the month.  10 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class te1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1=in.nextLine();
            String n="";
            for(int i=1;i<line1.length()-1;i++){
                n+=line1.charAt(i);
            }
            line1=n;
            if(line1.length()==1){
                System.out.println(line1);
            }else {
                String[] strs=line1.split(",");
                List<String> ans=new ArrayList<>();
                Set<String> set=new HashSet<>();
                for(String now:strs){
                    set.add(now);
                }
                if(strs.length<=3){
                    //叠放不了
                    for(String a:strs){
                        ans.add(a);
                    }
                    for(int i=0;i< ans.size();i++){
                        if(i== ans.size()-1){
                            System.out.print(ans.get(i));
                            continue;
                        }
                        System.out.print(ans.get(i)+",");
                    }
                }else {
                    for(int i=0;i< strs.length;i++){
                        String now=strs[i];
                        if(set.contains(now)){
                            int size=0;
                            String temp=now;
                            while(set.contains(temp)){
                                size++;
                                Integer b=Integer.parseInt(temp)+1;
                                temp=b+"";
                            }
                            if(size>=3){
                                //删除
                                Integer left=Integer.parseInt(now);
                                Integer right=Integer.parseInt(temp)-1;
                                for(int j=left;j<=right;j++){
                                    set.remove(j+"");
                                }
                                String nans=left+"-"+right;
                                ans.add(nans);
                                continue;
                            }else {
                                ans.add(now);
                                continue;
                            }
                        }else {
                            continue;
                        }

                    }
                    for(int i=0;i< ans.size();i++){
                        if(i== ans.size()-1){
                            System.out.print(ans.get(i));
                            continue;
                        }
                        System.out.print(ans.get(i)+",");
                    }
                }
            }







        }
    }
    public static void main1(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1=in.nextLine();
            line1=line1.substring(1,line1.length()-1);
            String[] strs=line1.split(",");
            List<String> ans=new ArrayList<>();
            for(int i=0;i< strs.length;i++){
                int j=i+1;
                while(j<strs.length&&(Integer.parseInt(strs[j-1])+1)==Integer.parseInt(strs[j])){
                    j++;
                }

            }


        }
    }
}
