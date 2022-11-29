import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-03 11:32 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  11:32 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  11 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meituan4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1=in.nextLine();
            String line2=in.nextLine();
            String line3=in.nextLine();
            String line4=in.nextLine();
            String[] split1 = line1.split(" ");
            //城市总数
            int n=Integer.parseInt(split1[0]);
            //天数
            int day=Integer.parseInt(split1[1]);
            //初始所在地
            int index=Integer.parseInt(split1[2]);
            //第i天任务需要的所在地index
            int[] day_n=new int[day];
            String[] s2 = line2.split(" ");
            for(int i=0;i<day;i++){
                day_n[i]=Integer.parseInt(s2[i]);
            }
            String[] s3 = line3.split(" ");
            String[] s4 = line4.split(" ");
            int[] at=new int[day];
            int[] notat=new int[day];
            for(int i=0;i<day;i++){
                at[i]=Integer.parseInt(s3[i]);
                notat[i]=Integer.parseInt(s4[i]);
            }
            System.out.print(getmax(n,day,index,day_n,at,notat));

        }
    }

    static int getmax(int n,int day,int start,int[] day_n,int[] at,int[] not){
        //最后一天可以获得的最大收益
        int[] dp=new int[day];
        //天数怎么表示
        //index=i+1;
        //如果第一天等于那边的第0天任务
        if(start==day_n[0]){
            //如果在那个城市
            //城市不用变
            dp[0]=at[0];
        }else {
            //如果不在那个城市
            //去那个城市
            start=day_n[0];
            //拿收益
            dp[0]=not[0];
        }
        //从第二天开始递推
        for(int i=1;i<day;i++){
            if(start==day_n[i]){
                //如果在
                //接或者不接
                dp[i]=Math.max(dp[i-1]+at[i],dp[i-1]);
                if(dp[i]==dp[i-1]+at[i]){
                    //接了
                    //在这个城市不变
                    start=day_n[i];
                }else {
                    start=day_n[i];
                }
            }else {
                //如果不在
                dp[i]=Math.max(dp[i-1]+not[i],dp[i-1]);
                //去或者不去
                if(dp[i]==dp[i-1]+not[i]){
                    //去了
                    start=day_n[i];
                }
            }

        }
        return dp[day-1];
    }
}
