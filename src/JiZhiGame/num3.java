package JiZhiGame;



import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-02-26 15:37 JiZhiGame - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/26 - the current system date.  15:37 - the current system time.  2023 - the current year.  02 - the current month.  26 - the current day of the month.  15 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num3 {

    public int[][] levelOrder (TreeNode root) {
        // write code here
        List<List<Integer>> lists = levelOrder1(root);
        int[][] ans=new int[lists.size()][];
        for(int i=0;i<ans.length;i++){
            int[] temp=new int[lists.get(i).size()];
            for(int j=0;j<lists.get(i).size();j++){
                temp[j]=lists.get(i).get(j);
            }
            ans[i]=temp;
        }
        return ans;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> Relanswer = new ArrayList<List<Integer>>();

        //利用队列来实现层序遍历

        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> judge=new LinkedList<>();

        judge.offer(root);

        while(!judge.isEmpty()){
            int len=judge.size();
            List<Integer> answer=new ArrayList<>();

            while(len>0){
                TreeNode now=judge.poll();
                answer.add(now.val);
                len--;
                if(now.left!=null){
                    judge.offer(now.left);
                }
                if(now.right!=null){
                    judge.offer(now.right);
                }

            }
            Relanswer.add(answer);
        }

        return Relanswer;
    }
}
