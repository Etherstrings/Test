package XIaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-20 18:44 XIaomi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/20 - the current system date.  18:44 - the current system time.  2022 - the current year.  09 - the current month.  20 - the current day of the month.  18 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        List<int[]> todo=new ArrayList<>();

        while(in.hasNextLine()){
                int ans=0;
                for(int i=0;i<Integer.MAX_VALUE;i++){
                    String now=in.nextLine();
                    if(now.equals("")){
                        break;
                    }
                    String line[]=now.split(" ");
                    int[] temp=new int[2];
                    temp[0]=Integer.parseInt(line[0]);
                    temp[1]=Integer.parseInt(line[1]);
                    todo.add(temp);
                }
            int left=todo.get(0)[0];
            int right=todo.get(0)[1];
            if(todo.size()==1){
                System.out.println(right-left+1);
            }else {
                for(int i=1;i< todo.size();i++){
                    int[] now=todo.get(i);
                    //左在右之间
                    if(now[0]<=right){
                        right=Math.max(right,now[1]);
                    }else {
                        ans+=(right-left);
                        left=now[0];
                        right=now[1];

                    }
                }
            }
            System.out.println(ans);
        }
        /**

         **/

    }
}
