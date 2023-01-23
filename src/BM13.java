import Mian.ListNode;
import Tool.ATool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-21 20:08
 */
public class BM13 {
    public static void main(String[] args) {
        List<Integer> objects = ATool.String2ArrayList("1234543211");
        ListNode head = ATool.Array2LinkedList(null, objects);
        System.out.println(isPail(head));
    }

    public static boolean isPail (ListNode head) {
        // write code here
        List<Integer> objects = ATool.LinkedList2ArrayList(head);
        List<Integer> t=new ArrayList<>();
        for(int n:objects){
            t.add(n);
        }
        Collections.reverse(objects);


        return objects.equals(t);
    }
}
