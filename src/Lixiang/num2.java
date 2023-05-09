package Lixiang;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-04-30 13:21 Lixiang - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/30 - the current system date.  13:21 - the current system time.  2023 - the current year.  04 - the current month.  30 - the current day of the month.  13 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    //找出最小的k个数
    public static List<Integer> getFirstK(int[] arr,int k){
        //小顶堆--堆顶小于每个子孩子
        Queue<Integer> small = new PriorityQueue<>((x, y) -> (x - y));
        for(int n:arr){
            small.offer(n);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(small.poll());
        }
        return ans;
    }
}
