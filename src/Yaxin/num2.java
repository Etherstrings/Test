package Yaxin;

import java.util.HashSet;

/**
 * @author Etherstrings
 * @create 2022-09-29 14:38 Yaxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/29 - the current system date.  14:38 - the current system time.  2022 - the current year.  09 - the current month.  29 - the current day of the month.  14 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public int cal (int N, int m) {
        // write code here
        //约瑟夫环
        int ans=0;
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=1;
        }
        int count=0;int num=0;
        for(int i=0;i<= arr.length;i++){
            if(i==arr.length){
                i=-1;
                continue;
            }
            if(arr[i]==1){
                count++;
                if(count==m){
                    arr[i]=0;
                    num++;
                    count=0;
                }
            }
            if(num==N-1){
                for(int j=0;j<N;j++){
                    if(arr[j]==1){
                        return j+1;
                    }
                }
            }
        }
        return ans;
    }
}
