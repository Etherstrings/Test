package zijie;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-18 10:37 zijie - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  te2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/18 - the current system date.  10:37 - the current system time.  2022 - the current year.  09 - the current month.  18 - the current day of the month.  10 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class te2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int n=Integer.parseInt(in.nextLine());
            List<int[]> todo=new ArrayList<>();
            for(int i=0;i<n;i++){
                String[] line=in.nextLine().split(" ");
                int m=Integer.parseInt(line[0]);
                int[] temp=new int[line.length];
                for(int j=0;j<line.length;j++){
                    temp[j]=Integer.parseInt(line[j]);
                }
                todo.add(temp);
            }
            int size=0;
            Set<Integer> Judge=new HashSet<>();
            for(int i=0;i<todo.size();i++){
                if(i==0){
                    //第一层
                    int[] now=todo.get(i);
                    //第一层的都可以放
                    size+=now[0];
                    for(int j=1;j<now.length;j++) {
                        for (int k = now[j]; k <= now[j] + 100; k++) {
                            Judge.add(k);

                        }
                    }
                    //Judge为第一层的有效区间
                    continue;
                }else {
                    int[] now=todo.get(i);
                    Set<Integer> temp=new HashSet<>();
                    for(int j=1;j<now.length;j++){
                        int target=(now[j]+100)/2;
                        if( Judge.contains(target)){
                                //可以放
                                size++;
                                for(int k=now[j];k<=now[j]+100;k++){
                                    temp.add(k);
                                }
                            }
                        }
                    //这一层结束了
                    Judge=temp;
                }
            }
            System.out.println(size);
        }
    }
}
