import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-07-31 11:02 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Lte - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/31 - the current system date.  11:02 - the current system time.  2022 - the current year.  07 - the current month.  31 - the current day of the month.  11 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class Lte {
    public static void main(String[] args) {
        Lte a=new Lte();
        int[] nums=new int[]{2,2,3,-1};
        System.out.println(a.closestMeetingNode(nums,0,1));
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        //用一个数组判断node1是不是到了这
        boolean[] used=new boolean[edges.length];
        used[node1]=true;
        //当前节点
        int now=node1;
        //指向的下一个节点
        int next=edges[node1];
        //当前总过走过的路线数
        int times=1;
        //如果下一个节点不是-1
        while(next!=-1||times>=edges.length){
            //当前节点为Ture
            used[now]=true;
            now=next;
            //下一个节点转为下一个节点
            next=edges[edges[now]];
            if(next==-1){
                used[now]=true;
                break;
            }
            times++;
        }

        int length=0;

        int Nnow=node2;
        int N2next=edges[node2];
        if (used[Nnow]==true) {
            //就是当前N2在N1的循环里

        }
        while(used[Nnow]!=true){
            length++;
            N2next=edges[N2next];
            if(used[N2next]==true){
                length++;
            }
        }
        return length;
    }
}
