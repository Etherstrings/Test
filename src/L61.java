/**
 * @author Etherstrings
 * @create 2022-06-09 12:56 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L61 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/9 - the current system date.  12:56 - the current system time.  2022 - the current year.  06 - the current month.  09 - the current day of the month.  12 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L61 {


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode Now=head;
        int i=2;
        while(i<6){
            Now.next=new ListNode(i);
            Now=Now.next;
            i++;
        };
        ListNode Cur=head;
        while(Cur!=null){
            System.out.print(Cur.val);
            Cur=Cur.next;
        }
        L61 l61 = new L61();
        l61.rotateRight(head,2);
        ListNode Se=head;
        while(Se!=null){
            System.out.print(Se.val);
            Se=Se.next;
        }

    }


    //61. 旋转链表
    //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4,5], k = 2
    //输出：[4,5,1,2,3]
    //示例 2：
    //
    //
    //输入：head = [0,1,2], k = 4
    //输出：[2,0,1]
    //
    //
    //提示：
    //
    //链表中节点的数目在范围 [0, 500] 内
    //-100 <= Node.val <= 100
    //0 <= k <= 2 * 109
     ListNode rotateRight(ListNode head, int k) {
        //思路 首先肯定有虚拟头节点
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;




        //判断链表长度和K的长度
        int test=k;
        ListNode Now=Dummy;
        while(Now!=null)
        {
            test--;
            Now=Now.next;
        }


        if(test<=0){
            //k大于链表长度
            ListNode Cur=Dummy.next;
            ListNode slow=Dummy;

            while(Cur.next!=null){
                Cur=Cur.next;
                slow=slow.next;
            }
            //此时Cur指向链表的最后一个位置
            Cur.next=Dummy.next;
            slow.next=null;
            return Cur;
        }


        //k<链表长度
        //思路 首先肯定有虚拟头节点
        ListNode NewNow=Dummy;
        ListNode Pre=Dummy;
        for(int i=0;i<k;i++){
            NewNow=NewNow.next;
        }
        while (NewNow.next!=null){
            NewNow=NewNow.next;
            Pre=Pre.next;
        }
        // 0 1 2 3 4 5
        // 4 5 1 2 3
        //此时 NewNow是最末尾的
        //此时 Pre指在3 NewNow指在5

        //存下来head
        ListNode Temp=Dummy.next;
        //0指向4
        Dummy.next=Pre.next;
        //5指向1 也就是头节点
        NewNow.next=Temp;
        //3指向空指针
        Pre.next=null;

        //返回头指针
        return Dummy.next;

    }
}
