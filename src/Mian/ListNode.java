package Mian;

/**
 * @author Etherstrings
 * @create 2022-09-21 14:30 Mian - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  ListNode - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/21 - the current system date.  14:30 - the current system time.  2022 - the current year.  09 - the current month.  21 - the current day of the month.  14 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class ListNode {

        //结点的数值---真实数值
        public int val;

        //下一个结点
        public ListNode next;

        // 节点的构造函数(无参)

        public ListNode() {
        }


        // 节点的构造函数(有一个参数)

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(ListNode next) {
            this.next = next;
        }
// 节点的构造函数(有两个参数)

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

}
