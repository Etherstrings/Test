package Tree;

/**
 * @author Etherstrings
 * @create 2023-02-26 15:42 Tree - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  TreeNode - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/26 - the current system date.  15:42 - the current system time.  2023 - the current year.  02 - the current month.  26 - the current day of the month.  15 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
