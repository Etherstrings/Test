package meidi;

import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author Etherstrings
 * @create 2022-09-14 23:01 meidi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meidi2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  23:01 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  23 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meidi2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        while(in.hasNextLine()){
            String str=in.nextLine();
            str=str.substring(1,str.length()-1);
            String[] strs=str.split(",");
            int[] nums=new int[strs.length];
            for(int i=0;i<strs.length;i++){
                nums[i]=Integer.parseInt(strs[i]);
            }
            HashSet<Integer> Judge=new HashSet<>();
            for(Integer a:nums){
                 Judge.add(a);
            }
            List<Integer> ans=new ArrayList<>();
            for(Integer a:Judge){
                ans.add(a);
            }
            Collections.sort(ans);
            for(int i=0;i< ans.size();i++){
                if(i== ans.size()-1){
                    System.out.print(ans.get(i));
                    continue;
                }else {
                    System.out.print(ans.get(i)+",");
                }

            }
        }

    }
}
