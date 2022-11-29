package OuKe;

/**
 * @author Etherstrings
 * @create 2022-09-16 14:27 OuKe - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  OuKe1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/16 - the current system date.  14:27 - the current system time.  2022 - the current year.  09 - the current month.  16 - the current day of the month.  14 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class OuKe1 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        // 指针a 指针b
        // a先走 b后走

        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;
        ListNode Pre=head;
        ListNode Now=head;
        for(int i=0;i<n;i++){
            Now=Now.next;
        }
        while(Now.next!=null){
            Now=Now.next;
            Pre=Pre.next;
        }
        Pre.next=Now;
        return Dummy.next;
    }
}
