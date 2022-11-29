package Yunzhanghu;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2022-09-22 22:25 Yunzhanghu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  22:25 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  22 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public int[] RightSideView (TreeNode root) {
        // write code here
        //层序遍历
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return null;
        }
        Queue<TreeNode> Judge=new LinkedList<>();
        Judge.offer(root);
        while(!Judge.isEmpty()){
            int size=Judge.size();
            for(int i=0;i<size;i++){
                TreeNode now=Judge.poll();
                if(i==size-1){
                    ans.add(now.val);
                }
                if(now.left!=null){
                    Judge.offer(now.left);
                }
                if(now.right!=null){
                    Judge.offer(now.right);
                }
            }
        }
        int[] t=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            t[i]=ans.get(i);
        }
        return t;
    }
}
