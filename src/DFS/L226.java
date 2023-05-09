package DFS;

import Yunzhanghu.TreeNode;

/**
 * @author Etherstrings
 * @create 2023-03-03 16:55 DFS - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L226 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/3 - the current system date.  16:55 - the current system time.  2023 - the current year.  03 - the current month.  03 - the current day of the month.  16 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L226 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left!=null&&root.right!=null){
            invertTree(root.left);
            invertTree(root.right);
            TreeNode Temp=root.left;
            root.left=root.right;
            root.right=Temp;

        }else if(root.left==null&&root.right!=null){
            invertTree(root.right);
            root.left=root.right;
            root.right=null;
        }else if(root.left!=null&&root.right==null){
            invertTree(root.left);
            root.right=root.left;
            root.left=null;
        }
        return root;
    }
}
