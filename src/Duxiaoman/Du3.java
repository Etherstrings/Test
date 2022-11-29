package Duxiaoman;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-15 19:14 Duxiaoman - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Du3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/15 - the current system date.  19:14 - the current system time.  2022 - the current year.  09 - the current month.  15 - the current day of the month.  19 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Du3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int n=Integer.parseInt(in.nextLine());
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                String[] line1=in.nextLine().split(" ");
                String str=in.nextLine();
                int len=Integer.parseInt(line1[0]);
                int p=Integer.parseInt(line1[1]);
                if(len/p==2){
                    //如果是回文---不需要
                    if(Huiwen(str)){
                        ans.add(0);
                        continue;
                    }else {
                        //不是回文--多少
                        int temp=HowMany(str,len,p);
                        ans.add(temp);
                        continue;
                    }
                }else {
                    //不是回文--多少
                    int temp=HowMany(str,len,p);
                    ans.add(temp);
                    continue;
                }
            }
            for(int times:ans){
                System.out.println(times);
            }
        }
    }
    static boolean Huiwen(String str){
        List<Character> temp=new ArrayList<>();
        for(Character a:str.toCharArray()){
            temp.add(a);
        }
        Collections.reverse(temp);
        String now="";
        for(Character a:temp){
            now+=a;
        }
        return str.equals(now);
    }

    static int HowMany(String str,int len,int p){
        if(len/p==2){
            String now=str.substring(0,p);
            String next=str.substring(p,len);
            int time=0;
            for(int i=0;i<next.length();i++){
                if(now.charAt(i)!=next.charAt(i)){
                    time++;
                }
            }
            return time;
        }
        boolean[] visited=new boolean[str.length()];
        for(int i=0;i<str.length();i++){
            visited[i]=false;
        }
        int ans=0;
        int i=0;
        while(visited[i]==false){
            //当前起步的这个被看了
            //比较当前取的这些 哪个比较多
            //取了多少个
            int n=0;
            //判断最多相同的有几个
            //将不是相同的变为相同的
            HashMap<Character,Integer> Judge=new HashMap<>();
            HashSet<Character> set=new HashSet<>();
            //最大值是哪个？
            int max=0;
            for(int j=i;j<str.length();j+=(p+1)){
                n++;
                Character a=str.charAt(j);
                visited[j]=true;
                if(Judge.containsKey(a)){
                    Judge.put(a,Judge.get(a)+1);
                }else {
                    Judge.put(a,1);
                }
                set.add(a);
            }
            for(Character a:set){
                max=Judge.get(a);
            }
            ans+=(n-max);
            i++;
        }
        return ans;
    }
}
