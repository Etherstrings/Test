package Hengsheng;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-23 18:57 Hengsheng - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/23 - the current system date.  18:57 - the current system time.  2023 - the current year.  03 - the current month.  23 - the current day of the month.  18 - the current hour.  57 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    //将nums拆分为最相近的数组
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String line1=in.nextLine();
        String[] words=line1.substring(7,line1.length()-1).split(",");
        int[] nums=new int[words.length];
        for(int i=0;i<words.length;i++){
            nums[i]=Integer.parseInt(words[i]);
        }
        String line2=in.nextLine();
        line2=line2.substring(line2.indexOf("=")+1,line2.length());
        int workerCount=Integer.parseInt(line2);
        Queue<int[]> xiao = new PriorityQueue<>((x, y) -> (x[1] - y[1]));
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<workerCount;i++){
            int[] temp=new int[]{i,0};
            xiao.add(temp);
            ans.add(new ArrayList<>());
        }
        //数组的[0]为桶的编号 [1]为当前的数值
        Arrays.sort(nums);
        for(int n:nums){
            int[] bucket=xiao.poll();
            int index=bucket[0];
            int sum=bucket[1];
            sum=sum+n;
            List<Integer> temp=ans.get(index);
            temp.add(n);
            ans.set(index,temp);
            int[] t=new int[]{index,sum};
            xiao.offer(t);
        }
        while(!xiao.isEmpty()){
            int[] temp=xiao.poll();
            int sum=temp[1];
            int index=temp[0];
            List<Integer> Bucket=ans.get(index);
            System.out.print(sum+":[");
            Collections.sort(Bucket);
            Collections.reverse(Bucket);
            for(int i=0;i<Bucket.size();i++){
                if(i==Bucket.size()-1){
                    System.out.println(Bucket.get(i)+"]");
                }else {
                    System.out.print(Bucket.get(i)+",");
                }
            }
        }

    }

}
