package Wangyi;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-18 20:21 Wangyi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/18 - the current system date.  20:21 - the current system time.  2022 - the current year.  09 - the current month.  18 - the current day of the month.  20 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNextLine()){
            String[] Charctersstr=in.nextLine().split(" ");
            if(Charctersstr.length==1){
                //只有一个角色
                System.out.println(0);
            }else {
                int[][] charcters=new int[Charctersstr.length][2];
                for(int i=0;i<Charctersstr.length;i++){
                    int[] temp=new int[2];
                    String[] trans=Charctersstr[i].split(",");
                    //攻击
                    temp[0]=Integer.parseInt(trans[0]);
                    //防御
                    temp[1]=Integer.parseInt(trans[1]);
                    charcters[i]=temp;
                }
                int num=0;
                for(int i=0;i<charcters.length;i++){
                    int[] now=charcters[i];
                    boolean flag=true;
                    for(int j=0;j<charcters.length;j++){
                        //我和每一个其他的都比较
                        if(j==i){
                            continue;
                        }
                        int[] other=charcters[j];
                        if((other[0]>now[0]&&other[1]>now[1])){
                            flag=false;
                            break;
                        }else {
                        }
                    }
                    if(flag==false){
                        num++;
                    }
                }
                System.out.println(num);
            }

        }
    }
}
