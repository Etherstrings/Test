package Nongshang;

import javax.swing.*;
import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-27 19:36 Nongshang - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/27 - the current system date.  19:36 - the current system time.  2022 - the current year.  09 - the current month.  27 - the current day of the month.  19 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            HashMap<String,Integer> Judge=new HashMap<>();
            Judge.put("Yuan",0);
            Judge.put("Fu",0);
            for(Character a:str.toCharArray()){
                if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u'){
                    Judge.put("Yuan", Judge.get("Yuan")+1);
                }else {
                    Judge.put("Fu",Judge.get("Fu")+1);
                }
            }
            DFS(Judge,0,str);
            Collections.sort(ans);
            System.out.println(ans.get(ans.size()-1));
        }
    }
    static LinkedList<String> Path=new LinkedList<>();
    static List<Integer> ans=new ArrayList<>();
    static void DFS(HashMap<String,Integer> Judge,int start,String str){
        if(Judge.get("Yuan")==0||Path.size()==str.length()){
            ans.add(Path.size());
            return;
        }
        for(int i=start;i<str.length();i++){
            if(i==0){
                //第一个
                //拼a
                //拼b
                Path.add("a");
                Judge.put("Yuan",Judge.get("Yuan")-1);
                DFS(Judge,i+1,str);
                Judge.put("Yuan",Judge.get("Yuan")+1);
                Path.removeLast();


                Path.add("b");
                Judge.put("Fu",Judge.get("Fu")-1);
                DFS(Judge,i+1,str);
                Judge.put("Fu",Judge.get("Fu")+1);
                Path.removeLast();

            }else {
                String last=Path.getLast();

                if(last.equals("a")){
                    //元音
                    Path.add("a");
                    Judge.put("Yuan",Judge.get("Yuan")-1);
                    DFS(Judge,i+1,str);
                    Judge.put("Yuan",Judge.get("Yuan")+1);
                    Path.removeLast();
                    Path.add("b");
                    Judge.put("Fu",Judge.get("Fu")-1);
                    DFS(Judge,i+1,str);
                    Judge.put("Fu",Judge.get("Fu")+1);
                    Path.removeLast();
                }else if(last.equals("b")){
                    //辅音
                    if(Judge.get("Yuan")==0){
                        break;
                    }else {
                        Path.add("a");
                        Judge.put("Yuan",Judge.get("Yuan")-1);
                        DFS(Judge,i+1,str);
                        Judge.put("Yuan",Judge.get("Yuan")+1);
                        Path.removeLast();
                    }
                }else {
                    Path.add("a");
                    Judge.put("Yuan",Judge.get("Yuan")-1);
                    DFS(Judge,i+1,str);
                    Judge.put("Yuan",Judge.get("Yuan")+1);
                    Path.removeLast();
                    Path.add("b");
                    Judge.put("Fu",Judge.get("Fu")-1);
                    DFS(Judge,i+1,str);
                    Judge.put("Fu",Judge.get("Fu")+1);
                    Path.removeLast();
                }
            }
        }
    }
}
