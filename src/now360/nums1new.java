package now360;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-09 15:26 now360 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  nums1new - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/9 - the current system date.  15:26 - the current system time.  2022 - the current year.  09 - the current month.  09 - the current day of the month.  15 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class nums1new {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1=in.nextLine();
            String[] lin1s=line1.split(" ");
            //表示数组长度
            int N=Integer.parseInt(lin1s[0]);
            //表示操作数组长度
            int M=Integer.parseInt(lin1s[1]);
            String[] numsstr=in.nextLine().split(" ");
            //初始数组nums
            List<Integer> nums=new ArrayList<>();
            for(String numss:numsstr){
                nums.add(Integer.parseInt(numss));
            }
            //操作数组
            List<Integer> todolist=new ArrayList<>();
            for(int i=0;i<M;i++){
                String[] temp=in.nextLine().split(" ");
                if(temp[0].equals("0")){
                    //升序排列
                    //排列的是指第几个数
                    //变为索引---i
                    todolist.add(Integer.parseInt(temp[1])-1);
                }else {
                    //降序排列
                    todolist.add(-(Integer.parseInt(temp[1])-1));
                }
            }
            //操作数组 todolist
            //初始数组 nums
            for(int a:todolist){
                //用来保存操作数组
                List<Integer> temp=new ArrayList<>();

                for(int i=0;i<=Math.abs(a);i++){
                    temp.add(nums.get(i));
                }
                if(a>0){
                    //升序排列
                    Collections.sort(temp);
                    for(int i=0;i<temp.size();i++){
                        nums.set(i,temp.get(i));
                    }
                }else if(a<0){
                    //降序排列
                    Collections.sort(temp);
                    Collections.reverse(temp);
                    for(int i=0;i<temp.size();i++){
                        nums.set(i,temp.get(i));
                    }
                }else {
                    continue;
                }
            }
            for(int num:nums){
                System.out.print(num+" ");
            }
        }
    }
}
