import java.util.Stack;

/**
 * @author Justice_wby
 * @create 2023-01-29 0:14
 */
public class L2315 {
    public static void main(String[] args) {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|"));
    }

    public static int countAsterisks(String s) {
        int ans=0;
        Stack<Character> stack=new Stack<>();
        for(char now:s.toCharArray()){
            if(now=='|'){
                if(stack.isEmpty()){
                    stack.push(now);
                    continue;
                }else {
                    stack.pop();
                    continue;
                }
            }
            if(now=='*'){
                if(stack.isEmpty()){
                    ans++;
                }
            }
        }
        return ans;
    }
}
