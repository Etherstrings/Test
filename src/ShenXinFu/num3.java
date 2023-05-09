package ShenXinFu;


import Mian.ListNode;
import Tool.ATool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-07 20:02 ShenXinFu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/7 - the current system date.  20:02 - the current system time.  2023 - the current year.  03 - the current month.  07 - the current day of the month.  20 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        ListNode head=new ListNode(3,new ListNode(5,new ListNode(6,null)));
        System.out.println(reverseBetween(head));
    }


    public static ListNode reverseBetween (ListNode head) {
        // write code here
        List<Integer> temp=LinkedList2ArrayList(head);
        int index3=-1;
        int index6=-1;
        for(int i=0;i<temp.size();i++){
            if(temp.get(i)==3){
                index3=i;
                break;
            }
        }
        for(int i=temp.size()-1;i>=0;i--){
            if(temp.get(i)==6){
                index6=i;
                break;
            }
        }
        List<Integer> t=new ArrayList<>();
        for(int i=0;i<index3;i++){
            t.add(temp.get(i));
        }
        for(int i=index6;i>=index3;i--){
            t.add(temp.get(i));
        }
        for(int i=index6+1;i<temp.size();i++){
            t.add(temp.get(i));
        }
        return Array2LinkedList(null,t);
    }
    /**
    public ListNode getListNode(List<Integer> s){
        ListNode root = new ListNode(s.get(0));//生成链表的根节点，将数组第一个元素赋值给根节点
        ListNode other = root;//生成另一个节点，将其指向根节点root，这里other只是作为临时变量
        for(int i=1;i<s.size();i++){  //根节点已赋值，故从1开始
            ListNode temp = new ListNode(s.get(i));//每循环一次生成一个新的节点，并赋值
            other.next=temp;//将other的下一节点指向新生成的节点
            other=temp;//将other指向最后一个节点（other的下一个节点）
        }
        return root;
    }
     **/
    public static ListNode Array2LinkedList(int[] array, List<Integer> arraylist){
        Mian.ListNode head=null;
        if(array==null&&arraylist==null){
            return head;
        }
        if(array==null){
            if(arraylist.size()==1){
                int temp=(int)arraylist.get(0);
                head=new Mian.ListNode(temp);
                head.next=null;
                return head;
            }
            int temp=(int)arraylist.get(0);
            head=new Mian.ListNode(temp);
            Mian.ListNode Now=head;
            Mian.ListNode Dummy=new Mian.ListNode(-1);
            Dummy.next=head;
            for(int i=1;i<arraylist.size();i++){
                int t=(int)arraylist.get(i);
                Mian.ListNode node=new Mian.ListNode(t);
                Now.next=node;
                Now=Now.next;
            }
            Now.next=null;
            return Dummy.next;
        }
        if(arraylist==null){
            if(array.length==1){
                int temp=(int)array[0];
                head=new Mian.ListNode(temp);
                head.next=null;
                return head;
            }
            int temp=(int)array[0];
            head=new Mian.ListNode(temp);
            Mian.ListNode Now=head;
            Mian.ListNode Dummy=new Mian.ListNode(-1);
            Dummy.next=head;
            for(int i=1;i<array.length;i++){
                int t=(int)array[i];
                Mian.ListNode node=new Mian.ListNode(t);
                Now.next=node;
                Now=Now.next;
            }
            Now.next=null;
            return Dummy.next;
        }
        return head;
    }

    public static List<Integer> LinkedList2ArrayList(ListNode head){
        if(head==null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        ListNode now=head;
        while(now!=null){
            ans.add(now.val);
            now=now.next;
        }
        return ans;
    }
}
