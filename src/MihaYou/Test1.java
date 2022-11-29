package MihaYou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-14 19:31 MihaYou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Test1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  19:31 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  19 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Test1 {
    public static void main(String[] args) {
        int[] preorder=new int[]{3,9,20,15,7};
        int[] inorder=new int[]{9,3,15,20,7};
        Test1 a=new Test1();
        System.out.println(a.maxPathSum(preorder,inorder));
    }
    static List<Integer> ans=new ArrayList<>();
    static int sum=0;
    public int maxPathSum (int[] preorder, int[] inorder) {
        // write code here
        //先根据前序遍历和中序遍历构建树
        // 树的路径最大值
        TreeNode root=buildTree(preorder,inorder);
        //回溯找最大值
        Collections.sort(ans);
        return ans.get(ans.size()-1);
    }
    static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static void BackTarcking(TreeNode root){
        sum+=root.val;
        if(root.left==null&&root.right==null){
            ans.add(sum);
            return;
        }

        if(root.left!=null){

            BackTarcking(root.left);
            sum-=root.left.val;
        }

        if(root.right!=null){

            BackTarcking(root.right);
            sum-=root.right.val;
        }
    }

    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    static public TreeNode helper(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) return null;

        // val 为前序遍历第一个的值，也即是根节点的值
        // idx 为根据根节点的值来找中序遍历的下标
        int idx = inLeft, val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }

        // 根据 idx 来递归找左右子树
        root.left = helper(preorder, preLeft + 1, preLeft + (idx - inLeft),
                inorder, inLeft, idx - 1);
        root.right = helper(preorder, preLeft + (idx - inLeft) + 1, preRight,
                inorder, idx + 1, inRight);
        return root;
    }
}
