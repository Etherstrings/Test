package GaoTu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-09-16 19:25 GaoTu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/16 - the current system date.  19:25 - the current system time.  2022 - the current year.  09 - the current month.  16 - the current day of the month.  19 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        //括号匹配
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String kuohao=in.nextLine();
            Stack<Character> Judge=new Stack<>();
            boolean flag=true;
            for(Character a:kuohao.toCharArray()){
                //推反方向入栈
                if(a.equals('(')){
                    Judge.push(')');
                }else if(a.equals('[')){
                    Judge.push(']');
                }else if(a.equals('{')){
                    Judge.push('}');
                }else if(Judge.isEmpty()||!Judge.peek().equals(a)){
                    flag=false;
                    break;
                }else {
                    Judge.pop();
                }
            }
            if(Judge.isEmpty()){
                flag=true;
            }
            System.out.println(flag);
        }
    }
    static public boolean isValid(String s){
        //三种情况
        //左边括号多
        //右边括号多
        //中间括号无法消除
        Deque<Character> deque = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (temp == '(') {
                deque.push(')');
            }else if (temp == '{') {
                deque.push('}');
            }else if (temp == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != temp) {
                //这里说明
                //1.用完括号了 没有可以匹配当前的了
                //2.当前的括号和设定的不是一个 消不掉
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //判断是不是最后正好消完  而不是剩下左元素
        return deque.isEmpty();
    }
}
