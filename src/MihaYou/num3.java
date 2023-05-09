package MihaYou;



import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-19 21:37 MihaYou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  21:37 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  21 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    //int[] nums--不重复
    // len>=2
    // 1,2,4
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            Integer n=Integer.parseInt(in.nextLine());
            String[] line=in.nextLine().split(" ");
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=Integer.parseInt(line[i]);
            }
            int ans= subsets(nums);
            System.out.println(ans);
        }
    }

    public static int countSubsets(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            if (isValid(subset)) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean isValid(List<Integer> subset) {
        if (subset.size() <= 1) {
            return false;
        }
        for (int i = 1; i < subset.size(); i++) {
            if (subset.get(i) % subset.get(i - 1) != 0) {
                return false;
            }
        }
        return true;
    }

    static long result;// 存放符合条件结果的集合
    static LinkedList<Integer> path;// 用来存放符合条件结果
    public static int subsets(int[] nums) {
        result = 0;
        path = new LinkedList<>();
        subsetsHelper(nums, 0);
        final int MOD = 1000000007;
        return (int) (result% MOD);
    }

    private static void subsetsHelper(int[] nums, int startIndex){

        List<Integer> temp = new ArrayList<>(path);

        if(temp.size()>=2){
            if(isAllPowerOfTwo(temp)){
                result++;
            }
        }

        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }
    public static boolean isAllPowerOfTwo(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (nums.get(i) % nums.get(j) != 0 && nums.get(j) % nums.get(i) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
