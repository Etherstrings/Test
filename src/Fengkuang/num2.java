package Fengkuang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-04-23 10:49 Fengkuang - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/23 - the current system date.  10:49 - the current system time.  2023 - the current year.  04 - the current month.  23 - the current day of the month.  10 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        System.out.println(flipXImage(2,"1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4"));
    }
    public static String flipXImage(int width,String pixelsStr){
        //n行n列4个数字
        //里面存的是索引
        int[][] arr=new int[width][width];
        Map<Integer, List<String>> map=new HashMap<>();
        String[] pix=pixelsStr.split(",");
        int index=1;
        for(int i=0;i<pix.length;i+=4){
            List<String> temp=new ArrayList<>();
            for(int j=i;j<i+4;j++){
                temp.add(pix[j]);
            }
            map.put(index,temp);
            index++;
        }
        index=1;
        for(int i=0;i<width;i++){
            for(int j=0;j<width;j++){
                arr[i][j]=index;
                index++;
            }
        }
        flip(arr);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                List<String> temp=map.get(arr[i][j]);
                if(i==arr.length-1&&j==arr.length-1){
                    for(int k=0;k<temp.size();k++){
                        if(k==temp.size()-1){
                            ans.append(temp.get(k));
                            continue;
                        }else {
                            ans.append(temp.get(k)+",");
                        }
                    }
                    continue;
                }
                for(String now:temp){
                    ans.append(now+",");
                }
            }
        }
        return ans.toString();
    }

    public static void flip(int[][] arr){
        int rows=arr.length;
        int cols=arr.length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols/2;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[i][cols-j-1];
                arr[i][cols-j-1]=temp;
            }
        }
    }
}
