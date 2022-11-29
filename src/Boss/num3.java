package Boss;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-12 22:10 Boss - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/12 - the current system date.  22:10 - the current system time.  2022 - the current year.  09 - the current month.  12 - the current day of the month.  22 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            //中序遍历
            //5 7 1 2 10
            int n=Integer.parseInt(in.nextLine());
            String[] line2=in.nextLine().split(" ");
            //中序遍历的节点分数
            int[] values=new int[n];
            for(int i=0;i<n;i++){
                values[i]=Integer.parseInt(line2[i]);
            }
            //左中右
            //最左节点的分数
            int left=values[0];
            //最右节点的分数
            int right=values[n-1];


        }

    }
}
