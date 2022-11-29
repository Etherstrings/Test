package Mian;


import javax.management.DynamicMBean;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-09-21 14:25 Mian - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  nums - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/21 - the current system date.  14:25 - the current system time.  2022 - the current year.  09 - the current month.  21 - the current day of the month.  14 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class nums {
    public static void main(String[] args) {
        //1 2 3
        //3 2 1

        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,null)));
        System.out.println(isHuiwen(head));
        ListNode head1=new ListNode(1,new ListNode(1,new ListNode(1,null)));
        System.out.println(isHuiwen(head1));
        ListNode head2=new ListNode(1,new ListNode(3,new ListNode(1,null)));
        System.out.println(isHuiwen(head2));
    }
    public static boolean isHuiwen(ListNode head){
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;
        ListNode Pre= Dummy;
        ListNode Now= head;
        String ans="";
        while(Now!=null){
            ans+=Now.val;
            Now= Now.next;
        }
        String temp="";
        for(int i=ans.length()-1;i>=0;i--){
            temp+=ans.charAt(i);
        }
        return temp.equals(ans);
    }
}
