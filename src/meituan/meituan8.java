package meituan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-18 11:02 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan8 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  11:02 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  11 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class meituan8 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] word1=in.nextLine().split(" ");
        int N=Integer.parseInt(word1[0]);
        int X=Integer.parseInt(word1[1]);
        int Y=Integer.parseInt(word1[2]);
        //5 3
        int[][] goods=new int[N][2];
        for(int i=0;i<N;i++){
            String[] t=in.nextLine().split(" ");
            int[] temp=new int[2];
            temp[0]=Integer.parseInt(t[0]);
            temp[1]=Integer.parseInt(t[1]);
            goods[i]=temp;
        }
        ans=new ArrayList<>();
        Back(0,Y,goods,0,X,0);
        int maxg=-1;
        for(int[] choice:ans){
            maxg=Math.max(choice[0],maxg);
        }
        int sum=Integer.MAX_VALUE;
        for(int[] choice:ans){
            if(choice[0]==maxg){
                sum=Math.min(choice[1],sum);
            }
        }
        System.out.println(maxg+" "+sum);

    }
    public static List<int[]> ans;
    public static void Back(int sum,int k,int[][] goods,int index,int X,int times){
        if(sum>X){
            return;
        }
        if(index==goods.length){
            if(k==0){
                int[] temp=new int[2];
                temp[0]=times;
                temp[1]=sum;
                ans.add(temp);
            }
            return;
        }
        for(int i=index;i<goods.length;i++){
            if(k==0){
                //不能买折扣了
                //买原价
                sum+=goods[i][0];
                times=times+1;
                Back(sum,k,goods,i+1,X,times);
                times=times-1;
                sum-=goods[i][0];
                //不买
                Back(sum,k,goods,i+1,X,times);
            }else {
                //买折扣
                sum+=goods[i][1];
                times=times+1;
                k=k-1;
                Back(sum,k,goods,i+1,X,times);
                k=k+1;
                times=times-1;
                sum-=goods[i][1];
                //买原价
                sum+=goods[i][0];
                times=times+1;
                Back(sum,k,goods,i+1,X,times);
                times=times-1;
                sum-=goods[i][0];
                //不买
                Back(sum,k,goods,i+1,X,times);
            }
        }
    }
}
