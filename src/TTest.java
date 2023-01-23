

/**
 * @author Justice_wby
 * @create 2023-01-16 3:18
 */
public class TTest {
    public static void main(String[] args) {
        ListNode pHead=new ListNode(1);
        pHead.next=new ListNode(2);
        pHead.next.next=new ListNode(3);
        pHead.next.next.next=new ListNode(4);
        pHead.next.next.next.next=new ListNode(5);
        removeNthFromEnd(pHead,2);
    }
    public static ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(k==0){
            return null;
        }
        if(pHead==null){
            return null;
        }
        int len=0;
        ListNode P=pHead;
        while(P!=null){
            len++;
            P=P.next;
        }
        if(len<k){
            return null;
        }
        if(len==k){
            return pHead;
        }
        ListNode Dummy=new ListNode(-1);
        Dummy.next=pHead;
        ListNode Pre=Dummy;
        ListNode Now=Dummy.next;
        for(int i=0;i<k;i++){
            Now=Now.next;
        }
        while(Now!=null){
            Now=Now.next;
            Pre=Pre.next;
        }
        return Pre.next;
    }
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here

        if(n==0){
            return null;
        }
        if(head==null){
            return null;
        }
        int len=0;
        ListNode P=head;
        while(P!=null){
            len++;
            P=P.next;
        }
        if(len<n){
            return null;
        }
        if(len==n){
            return head.next;
        }
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;

        ListNode Pre=Dummy;
        ListNode Now=Dummy.next;
        for(int i=0;i<n;i++){
            Now=Now.next;
        }
        while(Now!=null){
            Now=Now.next;
            Pre=Pre.next;
        }
        return Pre.next;
    }
}
