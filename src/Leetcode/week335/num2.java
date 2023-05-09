package Leetcode.week335;

import Yunzhanghu.TreeNode;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-05 10:59 Leetcode.week335 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/5 - the current system date.  10:59 - the current system time.  2023 - the current year.  03 - the current month.  05 - the current day of the month.  10 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Set=new HashSet<>();
        List<Long> ans=BFS(root);
        if(Set.size()<k){
            return -1;
        }
        List<Long> temp=new ArrayList<>();
        for(Long n:Set){
            temp.add(n);
        }
        Collections.sort(temp);
        Collections.reverse(temp);
        return temp.get(k-1);

    }
    public static HashSet<Long> Set;
    public static List<Long> BFS(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> Jud=new LinkedList<>();
        Jud.add(root);
        List<Long> ans=new ArrayList<>();
        while(!Jud.isEmpty()){
            int size=Jud.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode now=Jud.poll();
                sum=sum+now.val;
                if(now.left!=null){
                    Jud.offer(now.left);
                }
                if(now.right!=null){
                    Jud.offer(now.right);
                }
            }
            Set.add(sum);
            ans.add(sum);
        }
        return ans;
    }
}
