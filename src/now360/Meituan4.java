package now360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-10 17:28 now360 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Meituan4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/10 - the current system date.  17:28 - the current system time.  2022 - the current year.  09 - the current month.  10 - the current day of the month.  17 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Meituan4 {
    //挨个切
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            int size=0;
            int sum=0;
            int slow=0;
            List<String> temp=new ArrayList<>();
            int left=0;
            int ans=0;
            List<Integer> index=new ArrayList<>();
            for(int i=0;i<str.length();i++){
                if(Integer.parseInt(str.charAt(i)+"")%7==0){
                    ans++;
                    index.add(i);
                }
            }
            if(index.get(index.size()-1)!=str.length()-1){
                //最后一个不在最后一个
                for(int i=1;i<index.size();i++){
                    if(index.get(i)-index.get(i-1)!=0){
                        temp.add(str.substring(i+1,i));
                    }
                    if(index.get(index.size()-1)!=str.length()-1){
                        //最后一个不在最后一个
                        temp.add(str.substring(index.get(index.size())+1,str.length()));
                    }
                }
                temp.add(str.substring(index.get(index.size())+1,str.length()));
            }else {
                for(int i=1;i<index.size();i++){
                    if(index.get(i)-index.get(i-1)!=0){
                        temp.add(str.substring(i+1,i));
                    }
                    if(index.get(index.size()-1)!=str.length()-1){
                        //最后一个不在最后一个
                        temp.add(str.substring(index.get(index.size())+1,str.length()));
                    }
                }
            }
            for(String a:temp){
                int now=0;
                for(char b:a.toCharArray()){
                    now+=Integer.parseInt(b+"");
                }

            }
            System.out.println(ans);
        }
    }

}
