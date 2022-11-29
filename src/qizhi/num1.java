package qizhi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-21 20:33 qizhi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/21 - the current system date.  20:33 - the current system time.  2022 - the current year.  09 - the current month.  21 - the current day of the month.  20 - the current hour.  33 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int headval=in.nextInt();
            LinkedList<Integer> list=new LinkedList<>();
            list.add(headval);
            for(int i=0;i<n-1;i++){
                int val=in.nextInt();
                int root=in.nextInt();
                int index=list.indexOf(root);
                list.add(index+1,val);
            }
            int del=in.nextInt();
            int index=list.indexOf(del);
            list.remove(index);
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
        }
    }
}
