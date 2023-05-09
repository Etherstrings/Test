package meituan;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-12 19:27 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  19:27 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  19 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] words=in.nextLine().split(" ");
        int N=Integer.parseInt(words[0]);
        int M=Integer.parseInt(words[1]);
        int P=Integer.parseInt(words[2]);
        int[] ans=getans(N,M,P);
        if(ans.length==2){
            System.out.println(-1);
        }else {
            for(int i=0;i<ans.length;i++){
                if(i==ans.length-1){
                    System.out.print(ans[i]);
                    continue;
                }
                System.out.print(ans[i]+" ");
            }
        }
    }

    public static List<int[]> ans;

    public static int[] getans(int N,int M,int P){
        //初始化包装
        int[] Bucket=new int[M];
        //至少有一个
        Arrays.fill(Bucket,1);
        //每一个分一个还剩多少
        N=N-M;
        ans=new ArrayList<>();
        back(0,Bucket,P,N);
       Comparator<int[]> com=new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               for(int i=0;i<o1.length;i++){
                   if(o1[i]<o2[i]){
                       return -1;
                   }
                   if(o1[i]>o2[i]){
                       return 1;
                   }
                   if(o1[i]==o2[i]){
                       continue;
                   }
               }
               return 0;
           }
       };

        int[] a;
        if(ans.size()==0){
            a=new int[]{0,0};
        }else {
            Collections.sort(ans,com);
            a=ans.get(0);
        }
        return a;
    }
    //每个小包装中至少有一个
    public static void back(int index,int[] Bucket,int P,int N){
        int temp=0;
        for(int n:Bucket){
            temp+=n*n;
        }
        if(index==Bucket.length){
            if(temp==P&&N==0){
                int[] t=new int[Bucket.length];
                for(int i=0;i<Bucket.length;i++){
                    t[i]=Bucket[i];
                }
                ans.add(t);
            }
            return;
        }
        for(int i=index;i<Bucket.length;i++){
            if(N==0){
                continue;
            }
            for(int j=0;j<=N;j++){
                Bucket[i]+=j;
                N=N-j;
                back(i+1,Bucket,P,N);
                N=N+j;
                Bucket[i]-=j;
            }
        }
    }
}
