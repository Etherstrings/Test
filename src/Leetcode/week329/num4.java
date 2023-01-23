package Leetcode.week329;

import java.util.*;

/**
 * @author Justice_wby
 * @create 2023-01-22 10:52
 */
public class num4 {
    public static void main(String[] args) {
        int[] nums={1,2,1,2,1};
        System.out.println(minCost(nums,5));
    }
    HashSet<Integer> set=new HashSet<>();
    Integer temp=0;
    public static int minCost(int[] nums, int k) {
        //拆完之后的分割值最小
        //回溯
        //按照两个拆试一下？
        List<Integer> ans=new ArrayList<>();
        List<Integer> tt=new ArrayList<>();
        for(int n:nums){
            tt.add(n);
        }
        ans.add(trimmed(tt,k));
        for(int i=0;i<nums.length;i++){
            List<Integer> temp=new ArrayList<>();
            int t=0;
            for(int j=0;j<=i;j++){
                temp.add(nums[j]);
            }
            t+=trimmed(temp,k);
            temp=new ArrayList<>();
            for(int j=i+1;j<nums.length;j++){
                temp.add(nums[j]);
            }
            t+=trimmed(temp,k);
            ans.add(t);
        }
        Collections.sort(ans);
        return ans.get(0);
    }

    public static void dfs(){

    }



    public static int trimmed(List<Integer> spit,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:spit){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }else {
                map.put(n,1);
            }
        }
        int ans=k;
        for(Integer key: map.keySet()){
            if(map.get(key)==1){
                continue;
            }else {
                ans+=map.get(key);
            }
        }
        return ans;
    }
}
