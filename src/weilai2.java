import java.util.Scanner;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-09-02 17:14 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  weilai2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/2 - the current system date.  17:14 - the current system time.  2022 - the current year.  09 - the current month.  02 - the current day of the month.  17 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class weilai2 {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String nstr=in.nextLine();
            int n=Integer.parseInt(nstr);
            String numstr=in.nextLine();
            String[] s = numstr.split(" ");
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=Integer.parseInt(s[i]);
            }
            String mstr=in.nextLine();
            int m=Integer.parseInt(mstr);
            int[] Caozuo=new int[m];
            String CaozuoStr=in.nextLine();
            String[] s1 = CaozuoStr.split(" ");
            for(int i=0;i<m;i++){
                Caozuo[i]=Integer.parseInt(s1[i]);
            }
            //Caozuo[i]
            //nums

            int[] ans=new int[Caozuo.length];
            for(int i=0;i<Caozuo.length;i++){
                int now=Caozuo[i];
                int sum=0;
                for(int j=0;j<nums.length;j++){
                        nums[j]+=now;
                        sum+=Math.abs(nums[j]);
                }
                ans[i]=sum;
            }
            for(int a:ans){
                System.out.println(a);
            }
        }
    }
}
