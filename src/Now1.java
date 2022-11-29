import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-08-29 20:00 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Now1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  20:00 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  20 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class Now1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            //两数之和
            String howmany= in.nextLine();
            String temp=in.nextLine();
            String nums=in.nextLine();
            String[] words = nums.split(" ");
            //构建价格数组
            int[] prices=new int[words.length];
            for(int i=0;i<prices.length;i++){
                prices[i]=Integer.parseInt(words[i]);
            }
            int target=Integer.parseInt(temp);
            //按照出现的先后顺序排序
            //target减去当前的差 自身的index
            HashMap<Integer,Integer> Judge=new HashMap<>();
            List<List<Integer>> ans=new ArrayList<>();
            for(int i=0;i<prices.length;i++){
                if(Judge.containsKey(prices[i])){
                    List<Integer> now=new ArrayList<>();
                    now.add(prices[Judge.get(prices[i])]);
                    now.add(prices[i]);
                    ans.add(now);
                    break;
                }else {
                    Judge.put(target-prices[i],i);
                }
            }
            if(ans.size()==0){
                System.out.print("Not Found");
            }else {
                for(int i=0;i<ans.size();i++){
                    List<Integer> now=ans.get(i);
                    if(i==ans.size()-1){
                        //最后一个
                        for(int j=0;j<now.size();j++){
                            if(j==1){
                                System.out.print(now.get(1));
                                continue;
                            }
                            System.out.print(now.get(j)+" ");
                        }
                    }else {
                        for(int j=0;j< now.size();j++){
                            System.out.print(now.get(j)+" ");
                        }
                    }
                }
            }

        }
    }
}
