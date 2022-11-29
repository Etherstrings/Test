

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-16 21:38 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Test2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/16 - the current system date.  21:38 - the current system time.  2022 - the current year.  08 - the current month.  16 - the current day of the month.  21 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class Test2 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1,new TreeNode(2,null,null),new TreeNode(2,null,null));
        Test2 a=new Test2();
        System.out.println(a.minNumberOfHours(100,100,new int[]{1,2,3,4,5,6,7,8,9},new int[]{1,2,3,1,2,3,1,2,10}));
    }
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        //动态规划
        //模拟
        //当前状态
        //训练后状态
        //战斗后状态
        //训练时间
        //当前对手状态
        //倒叙

        if(energy.length==1){
            int ans=0;
            if(initialEnergy<=energy[0]){
                ans+=energy[0]+1-initialEnergy;
            }
            if(initialExperience<=experience[0]){
                ans+=experience[0]+1-initialExperience;
            }
            return ans;
        }
        int tempen=0;
        for(int i=energy.length-1;i>=0;i--){

            tempen+=energy[i];
        }
        if(initialEnergy<=tempen){
            tempen=tempen-initialEnergy+1;
        }else {
            tempen=0;
        }
        int tempce=0;
        for(int i=0;i<experience.length;i++){
            if(initialExperience<=experience[i]){
                tempce+=experience[i]+1-initialExperience;
                initialExperience=experience[i]+1+experience[i];
            }else {
                initialExperience+=experience[i];
            }
        }
        return tempen+tempce;
    }
    List<List<Integer>> ans=new ArrayList<>();
    LinkedList<Integer> Path=new LinkedList<>();
    int sum=0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return ans;
        }
        sum+=root.val;
        DFS(root,targetSum);
        return ans;
    }

    void DFS(TreeNode root, int targetSum){
        Path.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(Path));
            }
            return;
        }

        if(root.left!=null){
            sum+=root.left.val;

            DFS(root.left,targetSum);
            Path.removeLast();
            sum-=root.left.val;
        }
        if(root.right!=null){
            sum+=root.right.val;

            DFS(root.right,targetSum);
            Path.removeLast();
            sum-=root.right.val;
        }
    }
}
