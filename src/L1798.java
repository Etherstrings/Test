import java.util.HashSet;
import java.util.Set;

/**
 * @author Justice_wby
 * @create 2023-02-04 13:50
 */
public class L1798 {
    public static void main(String[] args) {
        int[] coins={1,1,1,4};
        System.out.println(getMaximumConsecutive(coins));
    }

    public static int getMaximumConsecutive(int[] coins) {
        if(coins==null){
            return 0;
        }
        int now=0;
        Set<Integer> set=new HashSet<>();
        set.add(now);
        for(int i=0;i<coins.length;i++){
            now+=coins[i];
            set.add(now);
        }
        now=0;
        for(int i=coins.length-1;i>=0;i--){
            now+=coins[i];
            set.add(now);
        }
        int ans=0;
        for(int i=0;i<=set.size();i++){
            if(set.contains(i)){
                ans++;
            }else {
                break;
            }
        }
        return ans;
    }
}
