import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-23 17:35 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Mina - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/23 - the current system date.  17:35 - the current system time.  2022 - the current year.  09 - the current month.  23 - the current day of the month.  17 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Mina {
    public static void main(String[] args) {
        int[] nums={1,1,2,2,3,4,5,5,5,6};
        List<Integer> now=getrank(nums);
        for(int a:now){
            System.out.print(a+" ");
        }
    }
    public static List<Integer> getrank(int[] nums){
        HashMap<Integer,Integer> Judge=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
            if(Judge.containsKey(num)){
                Judge.put(num,Judge.get(num)+1);
            }else {
                Judge.put(num,1);
            }
        }
        //出现次数--出现次数对应的num List
        HashMap<Integer,List<Integer>> value_key=new HashMap<>();
        //出现次数列表
        Set<Integer> values=new HashSet<>();
        for(Integer num:set){
            //出现次数
            int value=Judge.get(num);
            values.add(value);

            //出现次数---key列表
            if(value_key.containsKey(value)){
                //含有当前value
                List<Integer> temp=value_key.get(value);
                temp.add(num);

                //value_key.put(value,temp);
            }else {
                List<Integer> temp=new ArrayList<>();
                temp.add(num);
                value_key.put(Judge.get(num),temp);
            }
        }
        List<Integer> nvalues=new ArrayList<>(values);

        Collections.sort(nvalues);
        Collections.reverse(nvalues);
        //顺序
        List<Integer> ans=new ArrayList<>();

        for(int num:nvalues){
            //根据当前出现次数取出对应的数
            List<Integer> temp=value_key.get(num);

            for(int key:temp){
                int n=Judge.get(key);
                for(int i=0;i<n;i++){
                    ans.add(key);
                }
            }
        }
        return ans;

    }

}
