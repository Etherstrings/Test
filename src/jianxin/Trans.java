package jianxin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-10-29 19:34 jianxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Trans - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/29 - the current system date.  19:34 - the current system time.  2022 - the current year.  10 - the current month.  29 - the current day of the month.  19 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class Trans {
    public static void main(String[] args) {
        int[] t={1,2,2,3,4,5,3,3,3,4,5};
        String n="";
        for(int a:t){
            n+=a+"";
        }
        encode(n);
    }
    public static ListNode reverseList (ListNode head) {
        // write code here
        ListNode Now=head;

        List<Integer> temp=new ArrayList<>();
        while(Now!=null){
            temp.add(Now.val);
            Now=Now.next;
        }
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<temp.size();i++){
            int now=temp.get(i);
            int start=i;
            int end=i;
            while(end<temp.size()){
                if(now==temp.get(end)){
                    end++;
                    ans.add(now);
                }else {
                    //当前的位置的数 已经不是now了
                    i=end-1;
                    if(end==temp.size()-1){
                        ans.add(end);
                    }
                    //添加这些不重复的数
                    for(int j=end-1;j>=start;j--){
                        ans.add(temp.get(j));
                    }
                    break;
                }
            }
        }
        return null;

    }

    public static List<Integer> geta(List<Integer> temp){
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<temp.size();i++){
            int now=temp.get(i);
            int start=i;
            int end=i+1;
            while(end<temp.size()){
                if(now==temp.get(end)){
                    end++;
                    ans.add(now);
                }else {
                    //当前的位置的数 已经不是now了
                    i=end-1;
                    if(end==temp.size()-1){
                        ans.add(end);
                    }
                    //添加这些不重复的数
                    for(int j=end-1;j>=start;j--){
                        ans.add(temp.get(j));
                    }
                    break;
                }
            }
        }
        return ans;
    }

    public static void encode(String str) {
        if (str == null || str.equals("")) {
            System.out.println("");
            return;
        }

        // 利用StringBuffer变量字符串接受结果
        StringBuffer sb = new StringBuffer();

        char element = str.charAt(0);
        int count=1;
        for(int i=1;i<str.length();i++) {
            if(element==str.charAt(i)) {
                count++;
            }else {
                //当读到另一个不一样的字符的时候，再拼接之前统计的字符
                sb.append(element);
                //如果统计数量为1的时候不输出统计数量
                sb.append(count==1 ? "" :count);
                element = str.charAt(i);
                count=1;
            }
        }
        // 保证当最后一个字符和统计的数量都拼接上
        sb.append(element);
        sb.append(count==1 ? "" :count);

        // 输出整个结果
        System.out.println(sb.toString());
    }



}
