package meituan;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-18 10:02 meituan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meituan5 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/18 - the current system date.  10:02 - the current system time.  2023 - the current year.  03 - the current month.  18 - the current day of the month.  10 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class meituan5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] words=in.nextLine().split(" ");
        int N=Integer.parseInt(words[0]);
        //横坐标之差
        int A=Integer.parseInt(words[1]);
        //纵坐标之差
        int B=Integer.parseInt(words[2]);
        List<int[]> ens=new ArrayList<>();
        int bx=0;
        int by=0;
        for(int i=0;i<N;i++){
            int[] temp=new int[2];
            String[] ps=in.nextLine().split(" ");
            temp[0]=Integer.parseInt(ps[0]);
            temp[1]=Integer.parseInt(ps[1]);
            ens.add(temp);
            bx=Math.max(temp[0],bx);
            by=Math.max(temp[1],by);
        }
        boolean[][] show=new boolean[bx][by];
        boolean[][] used=new boolean[bx][by];
        for(int[] t:ens){
            show[t[0]-1][t[1]-1]=true;
        }
        int ans=0;
        for(int[] temp:ens){
            temp[0]=temp[0]-1;
            temp[1]=temp[1]-1;
            ans=Math.max(ans,BFS(temp,show,used,A,B));
        }
        System.out.println(ans);
    }

    public static int BFS(int[] temp,boolean[][] show,boolean[][] used,int A,int B){
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int sum=0;
        Queue<int[]> Judge = new LinkedList<>();
        Judge.offer(temp);
        used[temp[0]][temp[1]]=true;
        sum++;
        while(!Judge.isEmpty()){
            int[] now=Judge.poll();
            for(int i=-A;i<=A;i++){
                for(int j=-B;j<=B;j++){
                    int nowx=now[0]+i;
                    int nowy=now[1]+j;
                    if (nowx < 0 || nowx >= used.length || nowy < 0 || nowy >= used[0].length) {
                        continue;  // 越界了，直接跳过
                    }
                    if(show[nowx][nowy]==true&&!used[nowx][nowy]){
                        Judge.offer(new int[]{nowx,nowy});
                        used[nowx][nowy]=true;
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
