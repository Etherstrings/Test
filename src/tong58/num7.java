package tong58;

import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2023-03-11 0:51 tong58 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num7 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/11 - the current system date.  0:51 - the current system time.  2023 - the current year.  03 - the current month.  11 - the current day of the month.  00 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num7 {
    public static void main(String[] args) {
        System.out.println(calculate("3+5 / 2 + (2 - 3)"));
    }
    public static int calculate (String expression) {
        String str=trans(expression);
        return getans(str);
    }
    public static int getans (String expression) {
        // write code here
        char[] charArray=expression.toCharArray();
        int length=charArray.length;

        Stack<Integer> stack=new Stack<>();

        int number=0;

        char opr='+';

        for(int i=0;i<length;i++){
            char ch=charArray[i];

            if(ch=='('){
                int j=i+1;
                int count=1;
                while(count>1){
                    if(charArray[j]==')'){
                        count--;
                    }
                    if(charArray[j]=='('){
                        count++;
                    }
                    j++;
                }

                number=getans(expression.substring(i+1,j-1));
                i=j-1;
            }else if(Character.isDigit(ch)){
                number=number*10+ch-'0';
            }
            if(!Character.isDigit(ch)||i==length-1){
                if(opr=='+'){
                    stack.push(number);
                }else if(opr=='-'){
                    stack.push(number*-1);
                }else if(opr=='*'){
                    stack.push(stack.pop()*number);
                }else if(opr=='/'){
                    stack.push(stack.pop()/number);
                }
                opr=ch;
                number=0;
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }

    private static String trans(String expression){
        String str="";
        for(char n:expression.toCharArray()){
            if(n==' '){
                continue;
            }
            str+=n;
        }
        return str;
    }




}
