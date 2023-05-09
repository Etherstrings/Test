package Wanmei;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2023-03-12 12:15 Wanmei - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  12:15 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  12 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        System.out.println(solutions("foo(bar(baz))blim"));
        System.out.println(reverseParentheses("vdgzyj()"));
        //foo(barzab)blim
        //foobazrabblim
    }
    public static String reverseParentheses(String inputString) {
        Stack<Character> stack=new Stack<>();
        String left="";
        int l=-1;
        for(int i=0;i<inputString.length();i++){
            char n=inputString.charAt(i);
            if(n=='('||n==')'){
                l=i;
                break;
            }
            left+=n;
        }
        if(left.length()==inputString.length()){
            return left;
        }
        StringBuilder sb=new StringBuilder();
        int r=-1;
        for(int i=inputString.length()-1;i>=0;i--){
            if(inputString.charAt(i)=='('||inputString.charAt(i)==')'){
                r=i;
                break;
            }
            sb.append(inputString.charAt(i));
        }
        String right=sb.reverse().toString();
        if(l==-1&&r==-1){

        }
        for(int i=l;i<=r;i++){
            char n=inputString.charAt(i);
            if(n=='('){
                stack.push(')');
                continue;
            }
            if(n!='('&&n!=')'){
                if(stack.isEmpty()){
                }else {
                    stack.push(n);
                }
                continue;
            }
            if(n==')'){
                String temp="";
                while(stack.peek()!=n){
                    temp+=stack.pop();
                }
                stack.pop();
                for(char t:temp.toCharArray()){
                    stack.push(t);
                }
            }
        }

        if(stack.isEmpty()){
            return left+right;
        }
        sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return left+sb.reverse().toString()+right;
    }
    public static String solutions (String inputString) {
        // write code here
        Stack<Character> stack=new Stack<>();
        String left="";

        for(char n:inputString.toCharArray()){
            if(n=='('||n==')'){
                break;
            }
            left+=n;
        }
        StringBuilder sb=new StringBuilder();
        int r=-1;
        for(int i=inputString.length()-1;i>=0;i--){
            if(inputString.charAt(i)=='('||inputString.charAt(i)==')'){
                r=i;
                break;
            }
            sb.append(inputString.charAt(i));
        }
        String right=sb.reverse().toString();
        for(int i=0;i<=r;i++){
            char n=inputString.charAt(i);
            if(n=='('){
                stack.push(')');
                continue;
            }
            if(n!='('&&n!=')'){
                if(stack.isEmpty()){
                }else {
                    stack.push(n);
                }
                continue;
            }
            if(n==')'){
                String temp="";
                while(stack.peek()!=n){
                    temp+=stack.pop();
                }
                stack.pop();
                for(char t:temp.toCharArray()){
                    stack.push(t);
                }
            }
        }

        if(stack.isEmpty()){
            return "";
        }
        sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return left+sb.reverse().toString()+right;
    }
}
