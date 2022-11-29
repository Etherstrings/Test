import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-03 10:18 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  10:18 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  10 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meituan2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String nstr=in.nextLine();
            int n=Integer.parseInt(nstr);
            String nstrs=in.nextLine();
            String[] s = nstrs.split(" ");
            //i-value 这次要删除的数是什么？
            int[] con=new int[n];
            for(int i=0;i<n;i++){
                con[i]=Integer.parseInt(s[i]);
            }
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<con.length;i++){
                //每次第几个数
                //每次删第几个数？
                int index=i;
                ans.add(find(remove(con,index)));
            }
            for(int i=0;i<ans.size();i++){
                if(i==ans.size()-1){
                    System.out.print(ans.get(i));
                    break;
                }
                System.out.print(ans.get(i)+" ");
            }
        }
    }
    public static int[] remove(int[] arr,int index){
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i==index){
                continue;
            }
            ans.add(arr[i]);
        }
        int[] temp=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            temp[i]=ans.get(i);
        }
        return temp;
    }

    public static int find(int[] arr){
        Arrays.sort(arr);
        int min=arr[0];
        if(min==1){
            return 0;
        }
        int n=arr[arr.length-1];
        //应该是从min-n 都有出现才对
        //找第一个没出现的
        Set<Integer> Judge=new HashSet<>();
        for(int a:arr){
            Judge.add(a);
        }
        int ans=-1;
        for(int i=min;i<=n;i++){
            int temp=i;
            if(!Judge.contains(temp)){
                ans=temp;
                break;
            }
        }
        return ans;
    }
}
