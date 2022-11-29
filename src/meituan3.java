import sun.reflect.generics.tree.Tree;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-03 10:50 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  10:50 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  10 - the current hour.  50 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meituan3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int n=Integer.parseInt(in.nextLine());
            //第几个节点指向第几个节点？
            String line2=in.nextLine();
            String[] s = line2.split(" ");
            //每个节点对应的字母是什么？
            String line3=in.nextLine();
            String[] chars =new String[line3.length()];
            for(int i=0;i<line3.length();i++){
                chars[i]=line3.charAt(i)+"";
            }
            int[] nums=new int[s.length];
            for(int i=0;i<nums[i];i++){
                nums[i]=Integer.parseInt(s[i]);
            }
            //当前节点--指向当前节点
            HashMap<Integer, List<Integer>> Tree=new HashMap<>();

            for(int i=0;i<nums.length;i++){
                //当前是i+2节点
                int index=i+2;
                if(Tree.containsKey(nums[i]+1)){
                    List<Integer> temp=Tree.get(nums[i]+1);
                    temp.add(index);
                    Tree.put(nums[i]+1,temp);
                }else {
                    List<Integer> temp=new ArrayList<>();
                    temp.add(index);
                    Tree.put(nums[i]+1,temp);
                }
            }
            //从头到尾遍历
            //第几个节点 i+1 ----对应的有几个字母

            //当前节点的字母是什么？
            //i+1
            //当前节点怎么和字母对应
            int[] ans=new int[n];
            //从0到n-1
            //也就是从1到n节点
            //chars
            for(int i=0;i<ans.length;i++){
                int index=i+1;
                ans[i]= DFS(Tree,index,new HashSet<>(),chars).size();
            }
            for(int i=0;i<ans.length;i++){
                if(i==ans.length-1){
                    System.out.print(ans[i]);
                }else {
                    System.out.print(ans[i]+" ");
                }
            }
        }
    }

    static Set<String> DFS(HashMap<Integer, List<Integer>> Tree,int index,Set<String> Judge,String []chars){
        if(!Tree.containsKey(index)){
            return Judge;
        }
        Judge.add(chars[index]);
        List<Integer> integers = Tree.get(index);
        if(integers.size()==2){
            Set<String> left=DFS(Tree,integers.get(0),Judge,chars);
            Set<String> right=DFS(Tree,integers.get(1),Judge,chars);
            Set<String> ans=new HashSet<>();
            for(String a:left){
                ans.add(a);
            }
            for(String a:right){
                ans.add(a);
            }
            for(String a:Judge){
                ans.add(a);
            }
            return ans;
         }else {
            Set<String> ans=new HashSet<>();
            Set<String> one=DFS(Tree,integers.get(0),Judge,chars);
            for(String a:one){
                ans.add(a);
            }
            for(String a:Judge){
                ans.add(a);
            }
            return ans;
        }

    }
}
