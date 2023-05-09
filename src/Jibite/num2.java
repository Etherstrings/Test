package Jibite;

import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-12 15:44 Jibite - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/12 - the current system date.  15:44 - the current system time.  2023 - the current year.  03 - the current month.  12 - the current day of the month.  15 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1= in.nextLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int m=Integer.parseInt(line1[1]);
        int[][] Data=new int[m][3];
        for(int i=0;i<m;i++){
            String[] temp=in.nextLine().split(" ");
            int[] nums=new int[3];
            for(int j=0;j<3;j++){
                nums[j]=Integer.parseInt(temp[j]);
            }
            Data[i]=nums;
        }
        List<Integer> ans=getans(Data,n);
        for(int i=0;i<ans.size();i++){
            if(i==ans.size()-1){
                System.out.print(ans.get(i));
            }else {
                System.out.println(ans.get(i)+" ");
            }
        }
    }

    public static List<Integer> getans(int[][] Data,int city){
        return null;
    }
}
