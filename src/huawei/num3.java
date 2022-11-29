package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-10-12 19:33 huawei - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/12 - the current system date.  19:33 - the current system time.  2022 - the current year.  10 - the current month.  12 - the current day of the month.  19 - the current hour.  33 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            int Jinzhi=Integer.parseInt(in.nextLine());
            if(Jinzhi!=10){
                //将里面的进制数字转换为十进制数字
                String tra="";
                String temp="";
                for(int i=0;i<str.length();i++){
                    Character now=str.charAt(i);
                    if(Character.isDigit(now)||Character.isLetter(now)){
                        temp+=now;
                        if(i==str.length()-1){
                            temp=Integer.parseInt(temp,Jinzhi)+"";
                            tra+=temp;
                            continue;
                        }
                        continue;
                    }else {
                        temp=Integer.parseInt(temp,Jinzhi)+"";
                        tra+=temp;
                        tra+=now;
                        temp="";
                    }
                }
                str=tra;
            }
            //再转换为后缀表达式
            List<String> list=toInfixList(str);
            List<String> tempstr=parseSuff(list);
            String[] tokens=new String[tempstr.size()];
            for(int i=0;i<tokens.length;i++){
                tokens[i]=tempstr.get(i);
            }
            //后缀表达式四则运算
            int ans=poland(tokens);
            System.out.println(solve(ans,Jinzhi));
        }
    }
    //中缀表达式转换为List
    public static List<String> toInfixList(String s){
        List<String> list=new ArrayList<>();
        int i=0;
        String str;
        char c;
        do{
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                list.add(""+c);
                i++;
            }else {
                str="";
                while(i<s.length()&&(c=s.charAt(i))>48&&(c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                list.add(str);
            }
        }while (i<s.length());
        return list;
    }
    //中缀表达式List转为后缀表达式List
    public static List<String> parseSuff(List<String> ls){
        Stack<String> s1=new Stack<>();
        List<String> s2=new ArrayList<>();

        for(String item:ls){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while(s1.size()!=0&&getValue(s1.peek())>=getValue(item)){
                    s2.add(s1.pop());

                }
                s1.push(item);
            }
        }
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                break;
        }
        return result;
    }

    public static int poland(String[] tokens) {
        Stack<Integer> judgement=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if("+".equals(tokens[i])){
                int a=judgement.pop();
                int b=judgement.pop();
                judgement.push(a+b);

            }else if("-".equals(tokens[i])){
                int a=judgement.pop();
                int b=judgement.pop();
                judgement.push(b-a);

            }else if("*".equals(tokens[i])){
                int a=judgement.pop();
                int b=judgement.pop();
                judgement.push(a*b);

            }else if("/".equals(tokens[i])){
                int a=judgement.pop();
                int b=judgement.pop();
                judgement.push(b/a);
            }else{
                judgement.push(Integer.valueOf(tokens[i]));
            }
        }
        return judgement.pop();

    }

    public static String solve (int M, int N) {
        // write code here
        if(M==0)
            return "0";
        String s="0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        StringBuffer sb=new StringBuffer();
        boolean flag=false;
        if(M<0){
            flag=true;
            M=-M;
        }
        while(M!=0){
            sb.append(s.charAt(M%N));
            M=M/N;
        }
        if(flag==true)
            sb.append("-");
        return sb.reverse().toString();
    }


}
