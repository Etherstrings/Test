package sike;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-20 19:48 sike - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/20 - the current system date.  19:48 - the current system time.  2022 - the current year.  09 - the current month.  20 - the current day of the month.  19 - the current hour.  48 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            int m=Integer.parseInt(line1[1]);
            String[] line2=in.nextLine().split(" ");
            int[] powers=new int[line2.length];
            for(int i=0;i<powers.length;i++){
                powers[i]=Integer.parseInt(line2[i]);
            }
            int left=0;
            int right=0;
            boolean visited[]=new boolean[n];
            String[] which=new String[n];
            int times=1;
            boolean flag=true;
            while(flag){
                int index=-1;
                //查找最大值
                int maxpower=-1;
                for(int i=0;i<powers.length;i++){
                    if(visited[i]){
                        continue;
                    }
                    maxpower=Math.max(maxpower,powers[i]);
                    if(maxpower==powers[i]){
                        index=i;
                    }
                }
                //开始添加队伍
                String mark="";
                if(times%2==1){
                    //挑
                   mark="A";
                }else {
                    mark="B";
                }
                int r=0;
                visited[index]=true;
                which[index]=mark;
                for(int i=index;i<powers.length;i++){
                    if(visited[i]==true){
                        continue;
                    }else {
                        if(r<=m){
                            r++;
                            visited[i]=true;
                            which[i]=mark;
                        }else {
                            break;
                        }

                    }
                }
                int l=0;
                for(int i=index;i>=0;i--){
                    if(visited[i]==true){
                        continue;
                    }else {
                        if(l<=m){
                            l++;
                            visited[i]=true;
                            which[i]=mark;
                        }else {
                            break;
                        }

                    }
                }
                times++;
                for(boolean now:visited){
                    if(now!=true){
                        flag=true;
                        break;
                    }
                }
            }
            String ans="";
            for(String now:which){
                ans+=now;
            }
            System.out.println(ans);
        }
    }
}
