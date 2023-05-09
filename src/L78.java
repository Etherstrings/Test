import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-02-19 12:48 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L78 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/19 - the current system date.  12:48 - the current system time.  2023 - the current year.  02 - the current month.  19 - the current day of the month.  12 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L78 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        //互不相同的数组里
        //挨个取值
        if(nums==null||nums.length==0){
            return ans;
        }
        BackTarcking(nums,0);
        return ans;
    }
    static LinkedList<Integer> Path=new LinkedList<>();
    static List<List<Integer>> ans=new ArrayList<>();

    static void BackTarcking(int[] nums,int startindex){
        //挨个作为开头 作为子集
        //每一个进入的都是子集 都要计入
        ans.add(new ArrayList<>(Path));
        if(startindex>=nums.length){
            //取到头了 终止
            return;
        }

        for(int i=startindex;i<nums.length;i++){
            Path.add(nums[i]);
            BackTarcking(nums,i+1);
            Path.removeLast();
        }

    }
}
