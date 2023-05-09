package JinshanYun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-08 21:11 JinshanYun - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/8 - the current system date.  21:11 - the current system time.  2023 - the current year.  03 - the current month.  08 - the current day of the month.  21 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //哪一个
        char x = in.next().charAt(0);
        //当前这一个 失败了几回？
        int v = in.nextInt();
        //总时间数
        int t = in.nextInt();
        System.out.println(getans(x+"",v,t));
    }

    public static String getans(String x,int lose,int t){
        //去除成功的结果
        t=t-3;
        //t由1到3组成
        //几个3 几个2 几个1
        if(x.equals("a")){
            ans=new ArrayList<>();
            //12-3-3
            //6
            t=t-lose*1;
            Path=new int[3];
            //不需要考虑a
            Path[0]=lose;
            gg(0,t,0);
        }
        if(x.equals("b")){
            ans=new ArrayList<>();
            t=t-lose*2;
            Path=new int[3];
            //不需要考虑a
            Path[1]=lose;
            gg(0,t,1);
        }
        if(x.equals("c")){
            ans=new ArrayList<>();
            t=t-lose*3;
            Path=new int[3];
            //不需要考虑a
            Path[2]=lose;
            gg(0,t,2);
        }
        Integer max=Integer.MIN_VALUE;
        Integer min=Integer.MAX_VALUE;
        for(int n:ans){
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        return max+" "+min;
    }

    public static int[] Path;
    public static List<Integer> ans;
    public static void gg(int sum,int target,int noneed){
        if(sum>target){
            return;
        }
        if(sum==target){
            ans.add(Path[0]+Path[1]+Path[2]);
            return;
        }
        if(noneed==0){
            Path[1]=Path[1]+1;
            sum=sum+2;
            gg(sum,target,noneed);
            sum=sum-2;
            Path[1]=Path[1]-1;

            Path[2]=Path[2]+1;
            sum=sum+3;
            gg(sum,target,noneed);
            sum=sum-3;
            Path[2]=Path[2]-1;
        }

        if(noneed==1){
            Path[0]=Path[0]+1;
            sum=sum+1;
            gg(sum,target,noneed);
            sum=sum-1;
            Path[0]=Path[0]-1;

            Path[2]=Path[2]+1;
            sum=sum+3;
            gg(sum,target,noneed);
            sum=sum-3;
            Path[2]=Path[2]-1;
        }


        if(noneed==1){
            Path[0]=Path[0]+1;
            sum=sum+1;
            gg(sum,target,noneed);
            sum=sum-1;
            Path[0]=Path[0]-1;

            Path[1]=Path[1]+1;
            sum=sum+2;
            gg(sum,target,noneed);
            sum=sum-2;
            Path[1]=Path[1]-1;
        }
    }
}
