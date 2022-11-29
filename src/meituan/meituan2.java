package meituan;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-10 16:25 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/10 - the current system date.  16:25 - the current system time.  2022 - the current year.  09 - the current month.  10 - the current day of the month.  16 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meituan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            //首先将为0的加1
            //如果这时候为0
            //ans+1
            int n=Integer.parseInt(in.nextLine());
            int[] nums=new int[n];
            String[] strnum=in.nextLine().split(" ");
            for(int i=0;i<nums.length;i++){
                nums[i]=Integer.parseInt(strnum[i]);
            }
            int sum=0;
            for(int a:nums){
                sum+=a;
            }
            if(sum==0){
                //为0 需要调整
                int size=0;
                for(int a:nums){
                    if(a==0){
                        size++;
                    }
                }
                //里面没有0
                //但是和为0
                if(size==0){
                    System.out.println(1);
                }else {
                    //里面size有为0的
                    //和也为0
                    if(size==n){
                        System.out.println(n);
                    }else {
                        //不全部为0
                        if(size%2==0){
                            System.out.println(size+1);
                        }else {
                            System.out.println(size);
                        }
                    }
                }
            }else {
                //不为0
                //调整0就行
                int size=0;
                for(int a:nums){
                    if(a==0){
                        size++;
                    }
                }
                //不为0
                //为0的个数也为0
                if(size==0){
                    System.out.println(0);
                }else {
                    if(size%2==0){
                        System.out.println(size);
                    }else {
                        System.out.println(size+1);
                    }
                }
            }
            //首先要计算和是不是已经为0
            //如果不为0---那把所有的0变换后---也不应该为0
            //统计为0的个数size
            //挨个加一减一---如果最后size%2==1
            //那就是siez+1
        }
    }
}
