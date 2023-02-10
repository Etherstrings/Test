import Mian.ListNode;
import Tool.ATool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-28 23:46
 */
public class L86 {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode now=head;
        List<Integer> lower=new ArrayList<>();
        List<Integer> bigger=new ArrayList<>();
        while(now!=null){
            if(now.val==x){
                continue;
            }else if(now.val<x){
                lower.add(now.val);
            }else {
                bigger.add(now.val);
            }
            now=now.next;
        }
        List<Integer> all=new ArrayList<>();
        for(int n:lower){
            all.add(n);
        }
        all.add(x);
        for(int n:bigger){
            all.add(n);
        }
        return ATool.Array2LinkedList(null,all);

    }
}
