package tencent;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-10-16 20:21 tencent - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/16 - the current system date.  20:21 - the current system time.  2022 - the current year.  10 - the current month.  16 - the current day of the month.  20 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            int k=Integer.parseInt(line1[1]);
            //每次变化差值最大的数
            //并且更新当前变化值
            int sum=0;
            int[] nums=new int[n];
            String[] line2=in.nextLine().split(" ");
            for(int i=0;i<n;i++){
                nums[i]=Integer.parseInt(line2[i]);
                sum+=nums[i];
            }
            //构建好了
            //转换 并且维护一个当前差值-索引对应的数列
            HashMap<Integer,Integer> judge=new HashMap<>();
            ArrayList<Integer> panduan=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                int now=valuetransnum1(nums[i]);
                judge.put(i,now);
                panduan.add(now);
            }
            for(int i=0;i<k;i++){
                //循环k次
                Collections.sort(panduan);
                int cha=panduan.get(0);
                //找到改动的是哪一个
                //改动
                for(int j=0;j<nums.length;j++){
                    if(judge.get(j)==cha){
                        nums[j]=vatobin1(nums[j]);
                        break;
                    }
                }
                //更新sum
                sum+=cha;
            }
            System.out.println(sum);
        }
    }
    public static int vatobin1(int value){
        if(value==0){
            return value;
        }
        String bir=trans(value);
        int sum=0;
        for(char a:bir.toCharArray()){
            if(a=='1'){
                sum++;
            }
        }
        return sum;
    }
    public static int valuetransnum1(int value){
        //将当前的值转为当前值和1的个数的差值
        //如果 value>1的个数 再转换
        //如果 value<1的个数 不变
        if(value==0){
            return value;
        }
        String bir=trans(value);
        int sum=0;
        for(char a:bir.toCharArray()){
            if(a=='1'){
                sum++;
            }
        }
        if(sum<value){
            //能减去的值
            return sum-value;
        }else {
            //加上的值
            return sum-value;
        }
    }

    public static String trans(int value){
        String a = "";//用字符串拼接
        while(value!=0) {//利用十进制转二进制除2法
            a=value%2+a;
            value=value/2;
        }
        return a;
    }
}
