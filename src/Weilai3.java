import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-02 17:37 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Weilai3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/2 - the current system date.  17:37 - the current system time.  2022 - the current year.  09 - the current month.  02 - the current day of the month.  17 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Weilai3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String a=in.nextLine();
            String b=in.nextLine();
            int m=Integer.parseInt(b);
            String[] doors=new String[m];
            for(int i=0;i<m;i++){
                String door=in.nextLine();
                doors[i]=door;
            }
            int n=Integer.parseInt(a);
            int[] ans=new int[n];
            for(int i=0;i<n;i++){
                ans[i]=i;
            }
            //最后挨个加一
            //过门
            for(int i=0;i<doors.length;i++){
                String door=doors[i];
                if(door.equals("A")){
                    //更新后的数组的第一个人来开这个门!
                    //ans[] i第几个进  里面是第几个人
                    int person=ans[0];
                    for(int j=0;j<ans.length-1;j++){
                        int temp=ans[j+1];
                        ans[j]=ans[j+1];
                    }
                    ans[ans.length-1]=person;
                }else {
                    List<Integer> list=new ArrayList<>();
                    for(int person:ans){
                        list.add(person);
                    }
                    Collections.reverse(list);
                    for(int j=0;j< ans.length;j++){
                        ans[j]=list.get(j);
                    }
                }
            }
            for(int p:ans){
                System.out.println(p+1);
            }
        }
    }
}
