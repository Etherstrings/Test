package fenghuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-11-10 13:47 fenghuo - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/10 - the current system date.  13:47 - the current system time.  2022 - the current year.  11 - the current month.  10 - the current day of the month.  13 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class num4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);


            long a=in.nextLong();
            long b=in.nextLong();
            long c=in.nextLong();
            long sum=a+b;
            long big=0;
            HashMap<Long, List<String[]>> map=new HashMap<>();
            for(long i=0;i<=sum;i++){
                long nowa=i;
                long nowb=sum-nowa;
                long nans=nowa/c+nowb/c;
                big=Math.max(nans,big);
                String[] temp=new String[2];
                temp[0]=nowa+"";
                temp[1]=nowb+"";
                if(map.containsKey(nans)){
                    List<String[]> list = map.get(nans);
                    list.add(temp);
                }else {
                    List<String[]> list =new ArrayList<>();
                    map.put(nans,list);
                }
            }
            //找到了当前的最大值
            long ans=Long.MAX_VALUE;
            List<String[]> list=map.get(big);
            for(String[] temp:list){
                long na=Long.parseLong(temp[0]);
                long nb=Long.parseLong(temp[1]);
                ans=Math.min(ans,(Math.abs(na-a)+Math.abs(nb-b)));
            }
            System.out.println(ans);

    }
}
