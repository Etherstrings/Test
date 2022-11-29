package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-22 9:18 ali - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  moni1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  9:18 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  09 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class moni1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            int q=Integer.parseInt(line1[1]);
            String[] line2=in.nextLine().split(" ");
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=Integer.parseInt(line2[i]);
            }
            List<int[]> todolist=new ArrayList<>();
            for(int i=0;i<q;i++){
                String[] line=in.nextLine().split(" ");
                int[] temp=new int[3];
                temp[0]=Integer.parseInt(line[0]);
                temp[1]=Integer.parseInt(line[1]);
                temp[2]=Integer.parseInt(line[2]);
                todolist.add(temp);
            }
            for(int[] now:todolist){
                if(now[0]==1){
                    int index=now[1]-1;
                    nums[index]=now[2];
                    continue;
                }else {
                    //查找多少个
                    //前2个 那就是小于2
                    int index=now[1];
                    int target=now[2];
                    System.out.println(gethowmany(nums,index,target));
                }
            }
        }
    }

    static int gethowmany(int[] nums,int index,int targer){
        int ans=0;
        for(int i=0;i<index;i++){
            if(nums[i]==targer){
                ans++;
            }
        }
        return ans;
    }
}
