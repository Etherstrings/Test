package zijie;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-18 11:14 zijie - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  te4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/18 - the current system date.  11:14 - the current system time.  2022 - the current year.  09 - the current month.  18 - the current day of the month.  11 - the current hour.  14 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class te4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            int[] Judge=new int[4];
            Arrays.fill(Judge,0);
            for(Character a:str.toCharArray()){
                if(a=='A'){
                    Judge[0]+=1;
                    continue;
                }
                if(a=='S'){
                    Judge[1]+=1;
                    continue;
                }
                if(a=='D'){
                    Judge[2]+=1;
                    continue;
                }
                if(a=='F'){
                    Judge[3]+=1;
                    continue;
                }
            }
            //四个的个数怎么相同
            int sum=0;
            for(int i=0;i< Judge.length;i++){
                sum+=Judge[i];
            }
            int target=sum/4;
            boolean flag=false;
            int time=0;
            while(flag==false){
                boolean temp=true;
                int big=-1;
                int min=Integer.MAX_VALUE;
                int bindxe=-1;
                int mindxe=-1;
                for(int i=0;i<Judge.length;i++){
                    big=Math.max(Judge[i],big);
                    min=Math.min(Judge[i],min);
                }
                for(int i=0;i<Judge.length;i++){
                    if(Judge[i]==min){
                        mindxe=i;
                        continue;
                    }
                    if(Judge[i]==big){
                        bindxe=i;
                        continue;
                    }
                }
                int need=target-Judge[mindxe];
                time+=need;
                Judge[mindxe]=target;
                Judge[bindxe]=Judge[bindxe]-need;
                for(int i=0;i<Judge.length;i++){
                    if(Judge[i]!=target){
                        temp=false;
                        break;
                    }
                }
                flag=temp;
            }
            System.out.println(time);
        }
    }
}
