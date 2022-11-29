package tencent;

/**
 * @author Etherstrings
 * @create 2022-10-16 20:03 tencent - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/16 - the current system date.  20:03 - the current system time.  2022 - the current year.  10 - the current month.  16 - the current day of the month.  20 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public ListNode xorList (ListNode a, ListNode b) {
        // write code here
        // 翻转b 拼接b
        ListNode headb=b;
        StringBuffer sbb=new StringBuffer();
        while(headb!=null){
            sbb.append(headb.val);
            headb=headb.next;
        }
        String numb = sbb.reverse().toString();
        long num2 = Long.parseLong(numb, 2);
        // 拼接a
        ListNode heada=a;
        StringBuffer sba=new StringBuffer();
        while(heada!=null){
            sba.append(heada.val);
            heada=heada.next;
        }
        long num1=Long.parseLong(sba.toString(),2);
        long ans=num1^num2;
        //异或后结果转换为二进制String
        String tans=trans(ans);
        //转换
        ListNode head=new ListNode(0);
        ListNode tail=head;
        for(char now:tans.toCharArray()){
            ListNode temp=new ListNode(Integer.parseInt(now+""));
            tail.next=temp;
            tail=tail.next;
        }
        return head.next;
    }
    public static String trans(long ans){
        String a = "";//用字符串拼接
        while(ans!=0) {//利用十进制转二进制除2法
            a=ans%2+a;
            ans=ans/2;
        }
        return a;
    }
}
