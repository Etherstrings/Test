package meituan;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-18 11:42 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan10 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  11:42 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  11 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class meituan10 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] words=in.nextLine().split(" ");
        int N=Integer.parseInt(words[0]);
        //横坐标之差
        int A=Integer.parseInt(words[1]);
        //纵坐标之差
        int B=Integer.parseInt(words[2]);
        List<int[]> ens=new ArrayList<>();
        int level=-1;
        for(int i=0;i<N;i++){
            int[] temp=new int[2];
            String[] ps=in.nextLine().split(" ");
            temp[0]=Integer.parseInt(ps[0]);
            temp[1]=Integer.parseInt(ps[1]);
            level=Math.max(Math.max(temp[0],temp[1]),level);
            ens.add(temp);
        }
        int[][] grid=new int[level][level];
        for(int[] t:ens){
            grid[t[0]-1][t[1]-1]=1;
        }
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        };
        Collections.sort(ens,com);
        int ans=0;
        for(int i=0;i<ens.size();i++){
            int x=ens.get(i)[0]-1;
            int y=ens.get(i)[1]-1;
            int temp=1;
            for(int j=0;j<level;j++){
                for(int l=0;l<level;l++){
                    if(grid[j][l]==1&&j-x<=A&&l-y<=B){
                        temp++;
                    }
                }
            }
            ans=Math.max(temp,ans);
        }
        System.out.println(ans);
    }

}
