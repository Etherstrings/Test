package tong58;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-11 0:31 tong58 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num6 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/11 - the current system date.  0:31 - the current system time.  2023 - the current year.  03 - the current month.  11 - the current day of the month.  00 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num6 {
    //N
    //长N的数组
    //12347574
    //RBRRBRBR
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] nums=new int[n];
        String[] words=in.nextLine().split(" ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(words[i]);
        }
        char[] boo=in.nextLine().toCharArray();
        System.out.println(getans(nums,boo));
    }

    public static long getans(int[] nums,char[] boo){
        boolean[] used=new boolean[nums.length];
        ans=new ArrayList<>();
        tDFS(nums,boo,used,0,0);
        long t=Long.MIN_VALUE;
        for(int n:ans){
            t=Math.max(n,t);
        }
        return t;
    }

    public static List<Integer> ans;
    public static void tDFS(int[] nums,char[] boo,boolean[] used,int sum,int start){
        boolean flag=false;
        for(int i=start;i<nums.length-1;i++){
            if(used[i]||used[i+1]){
                continue;
            }
            //RRBB
            //1457
            if(boo[i]==boo[i+1]){
                continue;
            }
            flag=true;
            sum+=nums[i];
            sum+=nums[i+1];
            used[i]=true;
            used[i+1]=true;
            tDFS(nums,boo,used,sum,i+1);
            sum-=nums[i];
            sum-=nums[i+1];
            used[i]=false;
            used[i+1]=false;
        }
        if(flag==false){
            ans.add(sum);
        }
    }

    public static long getans1(int[] nums,char[] boo){
        boolean[] used=new boolean[nums.length];
        //每次都循环获取最大的
        long sum=0;
        boolean flag=true;
        while(flag){
            //int[index,sum]
            //大顶堆 按照数值排序
            Queue<int[]> que = new PriorityQueue<>((x, y) -> (y[1] - x[1]));
            for(int i=0;i<nums.length-1;i++){
                if(used[i]){
                    continue;
                }
                if(boo[i]!=boo[i+1]){
                    int temp=nums[i]+nums[i+1];
                    que.offer(new int[]{i,temp});
                }
            }
            if(que.size()==0){
                flag=false;
                break;
            }
            int[] t=que.poll();
            sum+=t[1];
            used[t[0]]=true;
        }
        return sum;
    }



}
