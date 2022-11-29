package yongshi;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-28 20:23 yongshi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/28 - the current system date.  20:23 - the current system time.  2022 - the current year.  09 - the current month.  28 - the current day of the month.  20 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1=in.nextLine();
            line1=line1.substring(11,line1.length());
            String[] Verson1=line1.split(".");
            String line2=in.nextLine();
            String[] Verson2=line2.substring(11,line2.length()).split(".");
            int index=0;
            boolean flag=true;
            int ans=0;
            while(index<Verson1.length&&index<Verson2.length){
                int a=Integer.parseInt(Verson1[index]);
                int b=Integer.parseInt(Verson2[index]);
                index++;
                if(a==b){
                    continue;
                }else if(a>b){
                    //a的版本号比b大
                    flag=false;
                    ans=1;
                    break;
                }else {
                    flag=false;
                    ans=-1;
                    break;
                }

            }
            if(index==Verson1.length&&index< Verson2.length){
                for(int i=index;i< Verson2.length;i++){
                    if(Integer.parseInt(Verson2[i])>0){
                        ans=-1;
                        break;
                    }
                }
            }else if(index==Verson2.length&&index< Verson1.length){
                for(int i=index;i< Verson1.length;i++){
                    if(Integer.parseInt(Verson1[i])>0){
                        ans=1;
                        break;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
