package tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-16 21:27 tencent - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/16 - the current system date.  21:27 - the current system time.  2022 - the current year.  10 - the current month.  16 - the current day of the month.  21 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            Integer n=Integer.parseInt(in.nextLine());
            List<Integer> nums=new ArrayList<>();
            String[] line2=in.nextLine().split(" ");
            for(int i=0;i<n;i++){
                nums.add(Integer.parseInt(line2[i]));
            }
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(nums.size()==1){
                    ans.add(nums.get(0));
                    nums.remove(0);
                    break;
                }
                if(i%2==0){
                    //大Q
                    if(nums.get(0)>nums.get(nums.size()-1)){
                        //头大取头
                        ans.add(nums.get(0));
                        nums.remove(0);
                        continue;
                    }else {
                        //尾大取尾
                        ans.add(nums.get(nums.size()-1));
                        nums.remove(nums.size()-1);
                        continue;
                    }
                }else {
                    //小Q
                    if(nums.get(0)<nums.get(nums.size()-1)){
                        //头小的话 取头
                        ans.add(nums.get(0));
                        nums.remove(0);
                        continue;
                    }else {
                        //尾小的话 取尾
                        ans.add(nums.get(nums.size()-1));
                        nums.remove(nums.size()-1);
                        continue;
                    }
                }
            }
            for(int now:ans){
                System.out.println(now+" ");
            }
        }
    }
}
