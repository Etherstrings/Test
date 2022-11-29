package yuque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-10-15 16:13 yuque - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/15 - the current system date.  16:13 - the current system time.  2022 - the current year.  10 - the current month.  15 - the current day of the month.  16 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            String[] line2=in.nextLine().split(" ");
            int size=Integer.parseInt(line1[0]);
            //第几个
            int index=Integer.parseInt(line1[1]);
            List<Integer> ans=new ArrayList<>();
            if(index==1){
                //第一个节点之后
                for(int i=0;i<index;i++){
                    ans.add(Integer.parseInt(line2[i]));
                }
                ans.add(index);
                for(int i=index;i<line2.length;i++){
                    ans.add(Integer.parseInt(line2[i]));
                }
            }else if(index==size){
                for(int i=0;i<line2.length;i++){
                    ans.add(Integer.parseInt(line2[i]));
                }
                ans.add(index);
            }else if(index==0){
                ans.add(index);
                for(int i=0;i<line2.length;i++){
                    ans.add(Integer.parseInt(line2[i]));
                }
            }else {
                //第一个节点之后
                for(int i=0;i<index;i++){
                    ans.add(Integer.parseInt(line2[i]));
                }
                ans.add(index);
                for(int i=index;i<line2.length;i++){
                    ans.add(Integer.parseInt(line2[i]));
                }
            }
            for(int a:ans){
                System.out.print(a+" ");
            }


        }
    }
    static class ListNode {
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
}
