package Wanmei;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2023-03-12 12:40 Wanmei - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  12:40 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  12 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num4 {
    public boolean validParentheses (String s) {
        //] }
        //" " null adadsada
        // write code here
        if(s.equals("")){
            return false;
        }
        if(s==null){
            return false;
        }
        String str="";
        for(char n:s.toCharArray()){
            if(n=='('||n==')'){
                str+=n;
            }
        }
        if(str.equals("")){
            return false;
        }
        s=str;
        Stack<Character> judgement=new Stack<>();
        char[] chars = s.toCharArray();

        for(int i=0;i<chars.length;i++){
            char now=chars[i];
            if(now=='('){
                judgement.push(')');
                continue;
            }
            if(now==')'){
                if(judgement.isEmpty()){
                    return false;
                }
                judgement.pop();
            }
        }
        return judgement.isEmpty();
    }

    public boolean validParentheses1 (String s) {
        // write code here
        if(s.equals("")){
            return false;
        }
        if(s==null){
            return false;
        }
        String str="";
        for(char n:s.toCharArray()){
            if(n=='('||n==')'){
                str+=n;
            }
        }
        if(str.equals("")){
            return false;
        }
        s=str;
        Stack<Character> judgement=new Stack<>();
        char[] chars = s.toCharArray();

        for(int i=0;i<chars.length;i++){

            if(chars[i]=='('){
                judgement.push(')');
            }else if(judgement.isEmpty()||judgement.peek()!=chars[i]){
                //如果栈顶元素不是当前遍历到的括号
                //那就无法一一消除
                return false;
            }else{
                judgement.pop();
            }
        }

        return judgement.isEmpty();
    }
}
