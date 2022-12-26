import java.util.*;

public class L1774 {
    public static void main(String[] args) {
        int[] baseCosts={2,3};
        int[] toppingCosts={4,5,100};
        System.out.println(closestCost(baseCosts,toppingCosts,18));
    }
    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        //一定要选冰激凌原料
        //配料可以选0 1 2份
        //DFS
        for(int base:baseCosts){
            int sum=base;
            DFS(0,toppingCosts,sum);
        }
        List<Integer> Temp=new ArrayList<>();
        for(Integer sum:Ans){
            if(sum==target){
                return sum;
            }
            Temp.add(Math.abs(sum-target));
        }
        Collections.sort(Temp);
        List<Integer> Next=new ArrayList<>();
        for(Integer sum:Ans){
            int abs=Math.abs(sum-target);
            if(abs==Temp.get(0)){
                Next.add(sum);
            }
        }
        return Next.get(0);
    }
    static HashSet<Integer> Ans=new HashSet<>();
    static LinkedList<Integer> Path=new LinkedList<>();
    public static void DFS(int index,int[] toppingCosts,int sum){
        //index 加的哪一种底料

        if(index==toppingCosts.length){
            Ans.add(sum);
            return;
        }else {
            Ans.add(sum);
        }
        for(int i=index;i<toppingCosts.length;i++){
            //加0份的有没有记录？
            DFS(i+1,toppingCosts,sum);

            sum+=toppingCosts[i];
            DFS(i+1,toppingCosts,sum);
            sum-=toppingCosts[i];

            sum+=2*(toppingCosts[i]);
            DFS(i+1,toppingCosts,sum);
            sum-=2*(toppingCosts[i]);

        }


    }
}
