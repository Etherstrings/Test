package YOngyou;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-02-25 15:29 YOngyou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/25 - the current system date.  15:29 - the current system time.  2023 - the current year.  02 - the current month.  25 - the current day of the month.  15 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num3 {

    public int[] monochromeTexasPoker (int[] cards) {
        // write code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:cards){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else {
                map.put(n,1);
            }
        }

        List<Integer> ans=new ArrayList<>();
        //1.4+1
        int temp=0;
        boolean flag=false;
        for(int key:map.keySet()){
            if(map.get(key)==4){
                flag=true;
                for(int i=0;i<4;i++){
                    ans.add(key);
                }
                continue;
            }
            temp=Math.max(temp,key);
        }
        ans.add(temp);
        if(flag){
            Collections.sort(ans);
            int[] t=new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                t[i]=ans.get(i);
            }
            return t;
        }
        //2.3+2
        temp=0;
        flag=false;
        ans=new ArrayList<>();
        List<Integer> three=new ArrayList<>();
        List<Integer> left=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==3){
                flag=true;
                three.add(key);
            }else {
                left.add(key);
            }
        }

        if(three.size()==1){
            for(int i=0;i<3;i++){
                ans.add(three.get(0));
            }
            Collections.sort(left);
            ans.add(left.get(left.size()-1));
            ans.add(left.get(left.size()-2));
        } else if (three.size()==2) {
            Collections.sort(three);
            for(int i=0;i<3;i++){
                ans.add(three.get(1));
            }
            ans.add(three.get(0));
            ans.add(three.get(0));
        }
        if(flag){
            Collections.sort(ans);
            int[] t=new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                t[i]=ans.get(i);
            }
            return t;
        }
        //4.2+2+1
        flag=false;
        ans=new ArrayList<>();
        List<Integer> two=new ArrayList<>();
        left=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==2){
                flag=true;
                two.add(key);
            }else {
                left.add(key);
            }
        }
        if(two.size()==1){
            //5.2+1+1+1
            Collections.sort(left);
            Collections.reverse(left);
            ans.add(two.get(0));
            ans.add(two.get(0));
            for(int i=0;i<5;i++){
                ans.add(left.get(i));
            }
        }else if(two.size()==2){
            Collections.sort(left);
            Collections.reverse(left);
            for(int i=0;i<two.size();i++){
                for(int j=0;j<2;j++){
                    ans.add(two.get(i));
                }
            }
            for(int i=0;i<3;i++){
                ans.add(left.get(i));
            }
        }else if(two.size()==3){
            Collections.sort(left);
            Collections.reverse(left);
            ans.add(left.get(0));
            ans.add(left.get(0));
            ans.add(left.get(1));
            ans.add(left.get(1));
            ans.add(left.get(2));
        }
        if(flag){
            Collections.sort(ans);
            int[] t=new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                t[i]=ans.get(i);
            }
            return t;
        }
        //6.1+1+1+1+1
        Arrays.sort(cards);
        int[] t=new int[5];
        for(int i=cards.length-1;i>=2;i--){
            t[i]=cards[i];
        }
        Arrays.sort(t);
        return t;









    }
}
