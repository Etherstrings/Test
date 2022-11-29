import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-07-17 10:55 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  newtest - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/17 - the current system date.  10:55 - the current system time.  2022 - the current year.  07 - the current month.  17 - the current day of the month.  10 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */

public class newtest {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String first=in.nextLine();
            List<int[]> con=new ArrayList<>();
            String[] firsts=first.split(" ");
            int m=Integer.parseInt(firsts[1]);
            if(m==0){
                System.out.print(Integer.parseInt(firsts[0]));
            }
            for(int i=0;i<m;i++){
                int[] temp=new int[3];
                String now=in.nextLine();
                String[] nows=now.split(" ");
                for(int j=0;j<3;j++){
                    temp[j]=Integer.parseInt(nows[j]);
                }
                con.add(temp);
            }
            //n个座位
            int[] nums=new int[Integer.parseInt(firsts[0])];
            //拼接条件！
            Arrays.fill(nums,1);
            //根据左侧排序
            Comparator<int[]> com=new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            };
            Collections.sort(con,com);
            //然后贪心
            for(int i=0;i<nums.length;i++){
                int[] temp=con.get(i);
                //左边作为开始
                if(temp[0]==temp[1]){
                    nums[temp[0]-1]=1;
                    con.remove(i);
                    continue;
                }
                if(temp[1]-temp[0]==temp[2]){
                    for(int j=temp[0]-1;j<=temp[1]-1;j++){
                        nums[j]=1;
                    }
                    con.remove(i);
                    continue;
                }
            }
            //过滤掉只有一个位置 或者区间位置坐满的
            for(int[] temp:con){
                int left=temp[0]-1;
                int right=temp[1]-1;
                int k=temp[2];
                for(int i=left;i<right;i++){
                    if(k==0){
                        break;
                    }
                    if(nums[i]==1){
                        continue;
                    }else {
                        nums[i]=1;
                        k--;
                    }
                }
            }
            int ans=nums.length;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    ans--;
                }
            }
            System.out.print(ans);
        }
    }


    public int maximumSum(int[] nums) {
        int maxsum=0;
        boolean flag=false;
        for(int i=0;i<nums.length-1;i++){
            int tempi=sumint(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                int temp=sumint(nums[j]);
                if(temp==tempi){
                    flag=true;
                    maxsum=Math.max(maxsum,nums[i]+nums[j]);
                }
            }
        }
        if(flag==false){
            return -1;
        }
        return maxsum;
    }

    int sumint(int num){
        //求这个数的和
        String temp = ""+num;
        int sum=0;
        for(Character a:temp.toCharArray()){
            sum+=Character.getNumericValue(a);
        }
        return sum;
    }
}
