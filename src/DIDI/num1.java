package DIDI;



import java.lang.ref.PhantomReference;
import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-17 15:22 DIDI - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/17 - the current system date.  15:22 - the current system time.  2022 - the current year.  09 - the current month.  17 - the current day of the month.  15 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            //回溯
            String str=in.nextLine();
            LinkedList<String> Path=new LinkedList<>();
            BackTarcking(str,0,Path);
            System.out.println(find(ans));
        }
    }
    static List<String> ans=new ArrayList<>();
    static void BackTarcking(String str,int startindex,LinkedList<String> Path){
        if(Path.size()==str.length()){
            String now="";
            for(String a:Path){
                now+=a;
            }
            ans.add(now);
            return;
        }
        for(int i=startindex;i<str.length();i++){
            Character now=str.charAt(i);
            if(now=='?'){
                for(int j=0;j<=9;j++){
                    Path.add(j+"");
                    BackTarcking(str,i+1,Path);
                    Path.removeLast();
                }
            }else {
                Path.add(now+"");
                continue;
            }


        }


    }
    static int find(List<String> ans){
        List<Integer> tans=new ArrayList<>();
        for(String a:ans){
            if(a.charAt(0)=='0'){
                continue;
            }
            boolean flag=false;
            for(int i=0;i<=9;i++){
                String t=""+i+i;
                if(a.contains(t)){
                    flag=false;
                    break;
                }
            }
            if(flag==false){
                continue;
            }
            int num=Integer.parseInt(a);
            if(num%3!=0){
                continue;
            }
            tans.add(num);
        }
        Collections.sort(tans);
        return tans.get(0);
    }
}
