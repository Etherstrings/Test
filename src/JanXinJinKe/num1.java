package JanXinJinKe;


import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2023-04-08 19:27 JanXinJinKe - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/8 - the current system date.  19:27 - the current system time.  2023 - the current year.  04 - the current month.  08 - the current day of the month.  19 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public TreeNode copyTree (TreeNode root) {
        // write code here
        TreeNode Temp=new TreeNode(0);
        Temp.left=dfs(root);
        Temp.right=root;
        return Temp;
    }

    public TreeNode dfs(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=dfs(root.left);
        TreeNode right=dfs(root.right);
        TreeNode Temp=new TreeNode(root.val);
        Temp.left=left;
        Temp.right=right;
        return Temp;
    }
}
