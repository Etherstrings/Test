package youka;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-10-11 19:54 youka - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/11 - the current system date.  19:54 - the current system time.  2022 - the current year.  10 - the current month.  11 - the current day of the month.  19 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,0,0,1,1,1,1,0,0};
        ArrayList<Integer> binaries=new ArrayList<>();
        for(int num:nums){
            binaries.add(num);
        }


    }
    public static ArrayList<Integer> findConsecutiveSubArr2 (ArrayList<Integer> binaries) {
        // write code here
        HashMap<Integer, List<String>> judge=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<binaries.size()-1;i++){
            int one=0;
            int zero=0;
            if(binaries.get(i)==0){
                zero++;
            }else {
                one++;
            }
            int size=one+zero;
            String temp="";
            temp+=binaries.get(i);
            for(int j=i+1;j<binaries.size();j++){
                if(binaries.get(j)==0){
                    zero++;
                }else {
                    one++;
                }
                temp+=binaries.get(j);
                if(zero==one){
                    if(judge.containsKey(zero+one)){
                        judge.get(zero+one).add(temp);
                    }else {
                        List<String> list=new ArrayList<>();
                        list.add(temp);
                        judge.put(zero+one,list);
                    }
                    set.add(zero+one);
                }else {
                    continue;
                }
            }
        }
        if(set.size()==0){
            return new ArrayList<>();
        }
        int max=-1;
        for(int size:set){
            max=Math.max(size,max);
        }
        List<String> list = judge.get(max);
        List<Integer> sortt=new ArrayList<>();
        for(String now:list){
            Integer t=Integer.parseInt(now,2);
            sortt.add(t);
        }
        Collections.sort(sortt);
        ArrayList<Integer> ans=new ArrayList<>();
        for(String tt:list){
            Integer t=Integer.parseInt(tt,2);
            if(t==sortt.get(sortt.size()-1)){
                for(Character c:tt.toCharArray()){
                    ans.add(Integer.parseInt(""+c));
                }
            }
        }
        return ans;
    }
}
