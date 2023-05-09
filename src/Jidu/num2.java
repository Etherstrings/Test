package Jidu;

import Tree.TreeNode;

/**
 * @author Etherstrings
 * @create 2023-03-31 15:36 Jidu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/31 - the current system date.  15:36 - the current system time.  2023 - the current year.  03 - the current month.  31 - the current day of the month.  15 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    //树型DP
    //打家劫舍
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);

    }
    //int[] 0不偷
    //int[] 1偷
    public int[] robTree(TreeNode root) {
        if (root == null)
            return new int[]{0,0};
        int[] left = robTree(root.left); // 左子树的盗窃情况
        int[] right = robTree(root.right); // 右子树的盗窃情况
        int butou = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 当不偷当前节点时，当前节点的左右孩子节点都能偷，但是要考虑能获取金额最大的方式
        int tou = root.val + left[0] + right[0]; // 当偷当前节点时，当前节点的左右孩子节点都不能偷
        return new int[]{butou, tou};
    }
}
