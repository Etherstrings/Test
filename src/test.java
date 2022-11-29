import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-02 15:51 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  test - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/2 - the current system date.  15:51 - the current system time.  2022 - the current year.  09 - the current month.  02 - the current day of the month.  15 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class test {
    public static void main(String[] args) {
        test a=new test();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        l1.add(1);
        List<Integer> l2=new ArrayList<>();
        l2.add(2);
        l2.add(3);
        ans.add(l1);
        ans.add(l2);
        List<Integer> l3=new ArrayList<>();
        l3.add(3);l3.add(-4);l3.add(-3);
        ans.add(l3);
        System.out.println(a.solution(ans));

    }
    List<Integer> ans=new ArrayList<>();
    public int solution(List<List<Integer>> arr) {
        // 在这⾥写代码
        DFS(0,0,arr,0);
        Collections.sort(ans);
        return ans.get(0);
    }

    void DFS(int level,int col,List<List<Integer>> arr,int sum){

        if(level==arr.size()){
            ans.add(sum);
            return;
        }
        sum+=arr.get(level).get(col);

        DFS(level+1,col,arr,sum);
        DFS(level+1,col+1,arr,sum);
    }

}
