package Waiqi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-17 1:56 Waiqi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/17 - the current system date.  1:56 - the current system time.  2022 - the current year.  09 - the current month.  17 - the current day of the month.  01 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static int maxPosPrefixes(List<Integer> arr) {
        // Write your code here
        int ans=0;
        Collections.sort(arr);
        Collections.reverse(arr);
        for(int i=0;i<arr.size();i++){
            int sum=0;
            for(int j=0;j<=i;j++){
                sum+=arr.get(j);
            }
            if(sum>0){
                ans++;
            }
        }
        return ans;
    }

    public static int maxPosPrefixes1(List<Integer> arr) {
        // Write your code here
        int ans=0;
        List<Integer> pos=new ArrayList<>();
        List<Integer> pas=new ArrayList<>();
        int zerosize=0;
        for(int a:arr){
            if(a>0){
                pos.add(a);
                continue;
            }
            if(a<0){
                pas.add(a);
            }
        }
        zerosize=arr.size()-pas.size()-pas.size();
        //pos从小到大
        //pas从大到小
        Collections.sort(pos);
        Collections.sort(pas);
        Collections.reverse(pas);
        List<Integer> temp=new ArrayList<>();
        for(int a:pos){
            temp.add(a);
        }
        for(int i=0;i<zerosize;i++){
            temp.add(0);
        }
        for(int a:pas){
            temp.add(a);
        }
        for(int i=0;i<temp.size();i++){
            int sum=0;
            for(int j=0;j<=i;j++){
                sum+=temp.get(j);
            }
            if(sum>0){
                ans++;
            }
        }
        return ans;
    }

}
