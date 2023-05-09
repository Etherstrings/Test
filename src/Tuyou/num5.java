package Tuyou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-12 13:58 Tuyou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num5 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  13:58 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  13 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        String[] line2=in.nextLine().split(" ");
        int w=Integer.parseInt(line1[0]);
        int n=Integer.parseInt(line1[1]);
        int[] takes=new int[n];
        for(int i=0;i<n;i++){
            takes[i]=Integer.parseInt(line2[i]);
        }
        List<Integer> t=getans(takes,w);
        System.out.println(t.size());
        for(int i=0;i<t.size();i++){
            if(i==t.size()-1){
                System.out.print(t.get(i));
                continue;
            }
            System.out.println(t.get(i)+" ");
        }
    }

    public static List<Integer> getans(int[] takes,int length){
        List<Integer> a=new ArrayList<>();
        int[] used=new int[length+1];
        Arrays.fill(used,0);
        ans=new ArrayList<>();
        Back(0,length,0,takes,used,1);
        for(int i=0;i<used.length;i++){
            boolean flag=true;
            for(int[] n:ans){
                if(n[i]==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                a.add(i+1);
            }
        }
        return a;
    }
    static List<int[]> ans;
    public static void Back(int sum,int length,int index,int[] takes,int[] used,int last){
        if(sum>=length){
            if(index==takes.length&&sum==length){
                ans.add(used);
            }
            return;
        }
        if(index==takes.length){
            ans.add(used);
            return;
        }
        for(int i=index;i<takes.length;i++){
            //直接铺 不加1
            if(last+takes[i]>length){
                break;
            }
            for(int j=last;j<=last+takes[i];j++){
                used[j]=1;
            }
            sum+=takes[i];
            last+=takes[i]+1;
            Back(sum,length,i+1,takes,used,last);
            sum-=takes[i];
            last-=takes[i]+1;
            for(int j=last;j<=last+takes[i];j++){
                used[j]=0;
            }

            if(last+1+takes[i]>length){
                break;
            }
            //加1
            for(int j=last+1;j<=last+takes[i]+1;j++){
                used[j]=1;
            }
            sum+=1;
            sum+=takes[i];
            last+=takes[i]+1+1;
            Back(sum,length,i+1,takes,used,last);
            sum-=1;
            sum-=takes[i];
            last-=takes[i]+1+1;
            for(int j=sum+1;j<sum+takes[i]+1;j++){
                used[j]=0;
            }
        }
    }

}
