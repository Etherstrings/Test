package fenghuo;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-19 11:34 fenghuo - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/19 - the current system date.  11:34 - the current system time.  2022 - the current year.  09 - the current month.  19 - the current day of the month.  11 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            //贪心
            //自己的伤害倍率
            //明白了
            String line1[]=in.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            int q=Integer.parseInt(line1[1]);
            String line2[]=in.nextLine().split(" ");
            List<Integer> my=new ArrayList<>();
            for(int i=0;i<line2.length;i++){
                my.add(Integer.parseInt(line2[i]));
            }
            String line3[]=in.nextLine().split(" ");
            List<Integer> enemy=new ArrayList<>();
            for(int i=0;i<line3.length;i++){
                enemy.add(Integer.parseInt(line3[i]));
            }
            List<int[]> todo=new ArrayList<>();
            Collections.sort(my);
            Collections.sort(enemy);
            for(int i=0;i<q;i++){
                int[] temp=new int[2];
                String[] now=in.nextLine().split(" ");
                temp[0]=Integer.parseInt(now[0]);
                temp[1]=Integer.parseInt(now[1]);
                todo.add(temp);
            }
            List<Integer> ans=new ArrayList<>();
            for(int[] now:todo){
                int sum=0;
                int me=now[0];
                int other=now[1];
                List<Integer> tempm=new ArrayList<>();
                List<Integer> temphe=new ArrayList<>();
                for(int i=0;i<my.size();i++){
                    tempm.add(my.get(i));
                    temphe.add(enemy.get(i));
                }
                if(me>=other){
                    //我的伤害倍率高
                    //用我的大的打他小的
                    //现在他是从小到大排列
                    Collections.reverse(tempm);
                    for(int i=0;i<tempm.size();i++){
                        int a=tempm.get(i)*me;
                        int b=temphe.get(i)*other;
                        if(a>b){
                            sum+=(a-b);
                        }else {
                            continue;
                        }
                    }
                }else {
                    //我的伤害倍率低
                    //用他的大的打我的小的
                    Collections.reverse(temphe);
                    for(int i=0;i<tempm.size();i++){
                        int a=tempm.get(i)*me;
                        int b=temphe.get(i)*other;
                        if(a>b){
                            sum+=(a-b);
                        }else {
                            continue;
                        }
                    }
                }
                ans.add(sum);
            }
            for(int a:ans){
                System.out.println(a);
            }


        }
    }
}
