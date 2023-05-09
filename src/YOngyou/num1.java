package YOngyou;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2023-02-25 15:24 YOngyou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/25 - the current system date.  15:24 - the current system time.  2023 - the current year.  02 - the current month.  25 - the current day of the month.  15 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num1 {

    public boolean isValid (String brackets) {
        // write code here
        Stack<Character> judgement=new Stack<>();
        char[] chars = brackets.toCharArray();

        int z=0;
        int x=0;
        int c=0;

        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                judgement.push(')');
            }else if(chars[i]=='['){
                judgement.push(']');
            }else if(chars[i]=='{'){
                judgement.push('}');

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
