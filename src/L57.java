import java.util.ArrayList;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-26 16:53
 */
public class L57 {
    public static void main(String[] args) {
        int[][] a={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] b={4,8};
        int[][] g=insert(a,b);
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp=new ArrayList<>();
        if(intervals==null||intervals.length==0){
            int[][] ans=new int[1][newInterval.length];
            ans[0]=newInterval;
            return ans;
        }
        int left=newInterval[0];
        int right=newInterval[1];
        int a=1;
        for(int i=0;i<intervals.length;i++){
            int mincur=intervals[i][0];
            int maxcur=intervals[i][1];
            if(i==intervals.length-1){
                if(a==1){
                    left=Math.min(left,mincur);
                    right=Math.max(right,maxcur);
                    temp.add(new int[]{left,right});
                    continue;
                }
            }
            if(maxcur<left){
                temp.add(intervals[i]);
                continue;
            }
            //是不是第一次大于
            if(mincur>right){
                if(a==1){
                    int[] t={left,right};
                    temp.add(t);
                    a++;
                }
                temp.add(intervals[i]);
                continue;
            }
            left=Math.min(left,mincur);
            right=Math.max(right,maxcur);
        }
        int[][] ans=new int[temp.size()][2];
        for(int i=0;i<ans.length;i++){
            ans[i]=temp.get(i);
        }
        return ans;
    }
}
