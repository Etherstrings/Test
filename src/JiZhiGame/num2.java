package JiZhiGame;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2023-02-26 15:31 JiZhiGame - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/26 - the current system date.  15:31 - the current system time.  2023 - the current year.  02 - the current month.  26 - the current day of the month.  15 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String s=in.nextLine();
            System.out.println(scoreOfPar(s));
        }
    }

    public static int scoreOfPar(String s){
        Stack<Integer> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(0);
            }else {
                if(stack.peek()==0){
                    stack.pop();
                    stack.push(1);
                }else {
                    int score=0;
                    while(!stack.isEmpty()&&stack.peek()!=0){
                        score+=stack.pop();
                    }
                    stack.pop();
                    stack.push(score<<1);
                }



            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
