package meidi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-14 23:25 meidi - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  meidi3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  23:25 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  23 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class meidi3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            //暴力匹配
            String M=in.nextLine();
            String N=in.nextLine();
            int start=-1;
            int end=-1;
            if(N.length()==1){
                if(M.contains(N)){
                    System.out.print(N);
                }else {
                    System.out.print("");
                }
            }else {
                //N的第一个字母在M的哪个地方开头？
                List<Integer> indexs=new ArrayList<>();
                for(int i=0;i<M.length();i++){
                    if(M.charAt(i)==N.charAt(0)){
                        indexs.add(i);
                    }
                }
                List<String> ans=new ArrayList<>();
                for(int index:indexs){
                    start=index;
                    boolean Flag=true;
                    if(index==M.length()-1){
                        continue;
                    }
                    String Str=M.substring(index+1,M.length());
                    //从第二个字母开始找
                    for(int i=1;i<N.length();i++){
                        String now=N.charAt(i)+"";
                        if(Str.indexOf(now)==-1){
                            //没找到
                            Flag=false;
                            break;
                        }
                        end=Str.indexOf(now);
                    }
                    if(Flag==true){
                        //找到了
                        String first=N.charAt(0)+"";
                        ans.add(first+Str.substring(0,end+1));
                    }else {
                        continue;
                    }
                }
                int size=Integer.MAX_VALUE;
                for(String a:ans){
                    size=Math.min(size,a.length());
                }
                List<String> tans=new ArrayList<>();
                for(String a:ans){
                    if(a.length()==size){
                        tans.add(a);
                    }
                }
                if(tans.size()==0){
                    System.out.println("");
                }else {
                    for(int i=0;i<tans.size();i++){
                        if(i==tans.size()-1){
                            System.out.print(tans.get(i));
                        }else {
                            System.out.print(tans.get(i)+" ");
                        }
                    }
                }
            }

        }
    }
}
