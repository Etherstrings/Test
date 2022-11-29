package meituan;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-10 15:58 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/10 - the current system date.  15:58 - the current system time.  2022 - the current year.  09 - the current month.  10 - the current day of the month.  15 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meituan1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int T=Integer.parseInt(in.nextLine());
            for(int i=0;i<T;i++){
                String[] nowline=in.nextLine().split(" ");
                int n=Integer.parseInt(nowline[0]);
                int x=Integer.parseInt(nowline[1]);
                int y=Integer.parseInt(nowline[2]);
                int target=Integer.parseInt(nowline[3]);
                //小美要做多少题？
                int mei=target;
                //朋友要做多少题？
                int pengyou=n-target+1;
                //小美的时间
                String[] timem=new String[2];

                //朋友的时间
                String[] timep=new String[2];

                //通分
                //通分美
                timem[1]=x*y+"";
                timem[0]=target*y+"";
                //通分朋友
                timep[1]=x*y+"";
                timep[0]=pengyou*x+"";

                if(Integer.parseInt(timem[0])==Integer.parseInt(timep[0])){
                    System.out.println("Tie");
                }else if(Integer.parseInt(timem[0])>Integer.parseInt(timep[0])){
                    System.out.println("Lose");
                }else {
                    System.out.println("Win");
                }
            }
        }
    }
}
