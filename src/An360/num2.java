package An360;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-18 15:12 An360 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  15:12 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  15 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        //修改
        int n=Integer.parseInt(line1[0]);
        //查询
        int m=Integer.parseInt(line1[1]);

        long maxlen=-1;
        List<long[]> tasks=new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] t=in.nextLine().split(" ");
            long[] temp=new long[3];
            temp[0]=Long.parseLong(t[0]);
            temp[1]=Long.parseLong(t[1]);
            temp[2]=Long.parseLong(t[2]);
            maxlen=Math.max(temp[1],maxlen);
            tasks.add(temp);
        }

        long[] toshow=new long[m];
        for(int i=0;i<m;i++){
            toshow[i]=Long.parseLong(in.nextLine());
        }
        /**
         *
         */
        /**
         Map<Long,Long> ans = getans(tasks);
         for(long index:toshow){
         if(ans.containsKey(index)){
         System.out.println(ans.get(index));
         }else {
         System.out.println(0);
         }
         }
         *
         */
        long[] ans=getans(tasks,maxlen);
        for(long index:toshow){
            System.out.println(ans[(int) index]);
        }
    }
    public static Map<Long,Long> getans(List<long[]> tasks){
        Map<Long,Long> temp=new HashMap<>();
        for(long [] todo:tasks) {
            long left = todo[0];
            long right = todo[1];
            long v = todo[2];
            for(long i=left;i<=right;i++){
                if(temp.containsKey(i)){
                    temp.put(i,temp.get(i)^v);
                }else {
                    temp.put(i,0^v);
                }
            }
        }
        return temp;
    }
    public static long[] getans(List<long[]> tasks,long maxlen){
        long[] ans = new long[(int)maxlen+1];
        Arrays.fill(ans,0);
        for(long [] todo:tasks){
            long left=todo[0];
            long right=todo[1];
            long v=todo[2];
            //与 x 的异或值 ^
            for(long i=left;i<=right;i++){
                ans[(int) i]=ans[(int) i]^v;
            }
        }
        return ans;
    }
}
