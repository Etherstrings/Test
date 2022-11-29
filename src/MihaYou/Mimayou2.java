package MihaYou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-14 19:49 MihaYou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Mimayou2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  19:49 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  19 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Mimayou2 {
    public static void main(String[] args) {
        Mimayou2 a=new Mimayou2();
        ArrayList<Integer> scores=new ArrayList<>();
        int[] temp=new int[]{90,80,88,95,66};
        for(int b:temp){
            scores.add(b);
        }
        ArrayList<String> strings = a.validResult(scores);
        for(String c:strings){
            System.out.println(c);
        }
    }
    public ArrayList<String> validResult (ArrayList<Integer> scores) {
        // write code here
        RankingList list=new RankingList();

        for(int i=1;i<= scores.size();i++){
            String temp=i+"";
            String b="UID-";
            if(temp.length()==1){
                b+="00"+temp;
            }else if(temp.length()==2){
                b+="0"+temp;
            }else {
                b+=temp;
            }
            list.put(b,scores.get(i-1));
        };
        int min=Integer.MAX_VALUE;
        int big=Integer.MIN_VALUE;
        for(int a:scores){
            min=Math.min(min,a);
            big=Math.max(big,a);
        }
        return list.getUserCodesByScoreScope(min,big);
    }
    class RankingList{
        ArrayList<String[]> list=new ArrayList<>();
        int min;
        int max;
        RankingList(){
            this.list=new ArrayList<>();
        };
        RankingList(ArrayList<String[]> list){
            this.list=list;
        }
        void put(String userCode,int socre){
            String[] temp=new String[2];
            temp[0]=userCode;
            temp[1]=""+socre;
            list.add(temp);
            Comparator<String[]> com=new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    int num1=Integer.parseInt(o1[1]);
                    int num2=Integer.parseInt(o2[1]);
                    return num1-num2;
                }
            };
            Collections.sort(list,com);
        }

        ArrayList<String> getUserCodesByScoreScope(int minScore,int maxScore){
            if(list==null){
                return new ArrayList<>();
            }
            String[] BigOne=list.get(list.size()-1);
            int big=Integer.parseInt(BigOne[1]);
            String[] MinOne=list.get(0);
            int min=Integer.parseInt(MinOne[1]);
            if(minScore>big){
                return new ArrayList<>();
            }else if(maxScore<min){
                return new ArrayList<>();
            }
            ArrayList<String> ans=new ArrayList<>();
            for(String[] temp:list){
                int now=Integer.parseInt(temp[1]);
                if(now>=minScore&&now<=maxScore){
                    ans.add(temp[0]);
                }
            }
            return ans;
        }
    }
}
