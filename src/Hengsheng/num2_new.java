package Hengsheng;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-23 19:29 Hengsheng - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2_new - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/23 - the current system date.  19:29 - the current system time.  2023 - the current year.  03 - the current month.  23 - the current day of the month.  19 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2_new {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String line1=in.nextLine();
        String[] words=line1.substring(7,line1.length()-1).split(",");
        int[] nums=new int[words.length];
        for(int i=0;i<words.length;i++){
            nums[i]=Integer.parseInt(words[i]);
        }
        String line2=in.nextLine();
        line2=line2.substring(line2.indexOf("=")+1,line2.length());
        workerCount=Integer.parseInt(line2);
        B_V=new HashMap<Integer, Integer>();
        Path=new HashMap<Integer, LinkedList<Integer>>();
        for(int i=0;i<workerCount;i++){
            B_V.put(i,0);
            Path.put(i,new LinkedList<>());
        }
        BackTarcking(nums,0);
        //从所有的ans中，选择出最小的差值最小的一个组合
        List<Integer> Com=new ArrayList<>();
        for(HashMap<Integer, LinkedList<Integer>> temp:ans){
            Com.add(gettrans(temp));
        }
        Collections.sort(Com);
        for(HashMap<Integer, LinkedList<Integer>> temp:ans){
            if(gettrans(temp)==Com.get(0)){
                List<Integer> comsum=new ArrayList<>();
                for(int i=0;i<workerCount;i++){
                    for(int n:temp.get(i)){

                    }
                }
            }
        }
    }
    public static List<HashMap<Integer, LinkedList<Integer>>> ans;
    public static HashMap<Integer, LinkedList<Integer>> Path;
    public static HashMap<Integer, Integer> B_V;
    public static int workerCount;
    public static void BackTarcking(int[] nums,int index){
        if(index==nums.length){
            boolean flag=true;
            for(int i=0;i<workerCount;i++){
                if(B_V.get(i)==0){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                ans.add(Path);
            }
            return;
        }
        for(int i=index;i<nums.length;i++){
            int now=nums[i];
            //N选一
            for(int j=0;j<workerCount;j++){
                int sum=B_V.get(j);
                sum+=now;
                LinkedList<Integer> Temp = Path.get(i);
                Temp.add(now);
                BackTarcking(nums,i+1);
                Temp.removeLast();
                sum-=now;
                B_V.put(j,sum);
            }
        }
    }

    public static int gettrans(HashMap<Integer, LinkedList<Integer>> temp){
        int ans=0;
        List<Integer> trans =new ArrayList<>();
        for(int key:temp.keySet()){
            LinkedList<Integer> s=temp.get(key);
            int sum=0;
            for(int n:s){
                sum+=n;
            }
            trans.add(sum);
        }
        Collections.sort(trans);
        int base=trans.get(0);
        for(int i=0;i<trans.size();i++){
            int tt=trans.get(i)-base;
            ans+=tt;
            trans.set(i,tt);
        }
        return ans;
    }
}
