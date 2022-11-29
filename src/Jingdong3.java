import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-09 10:26 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Jingdong3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/9 - the current system date.  10:26 - the current system time.  2022 - the current year.  09 - the current month.  09 - the current day of the month.  10 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Jingdong3 {
    public static void main(String[] args) {
        HashMap<Integer,Character> Judge=new HashMap<>();
        Judge.put(1,'a');
        Judge.put(2,'b');
        Judge.put(3,'c');
        Judge.put(4,'d');
        Judge.put(5,'e');
        Judge.put(6,'f');
        Judge.put(7,'g');
        Judge.put(8,'h');
        Judge.put(9,'i');
        Judge.put(10,'j');
        Judge.put(11,'k');
        Judge.put(12,'l');
        Judge.put(13,'m');
        Judge.put(14,'n');
        Judge.put(15,'o');
        Judge.put(16,'p');
        Judge.put(17,'q');
        Judge.put(18,'r');
        Judge.put(19,'s');
        Judge.put(20,'t');
        Judge.put(21,'u');
        Judge.put(22,'v');
        Judge.put(23,'w');
        Judge.put(24,'x');
        Judge.put(25,'y');
        Judge.put(26,'z');
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String num=in.nextLine();
            //按照大的优先拆分
            BigDecimal now = new BigDecimal(num);
            String ans="";
            boolean flag=true;
            while(!now.equals(new BigDecimal("0"))){
                if(ans.length()>10*10*10*10*10){
                    flag=false;
                    break;
                }
                if(now.compareTo(new BigDecimal("26"))==1||now.compareTo(new BigDecimal("26"))==0){
                    //比26大或者等于26
                    now.divide(new BigDecimal("26"));
                    ans+="26";
                }else {
                    //已经小于26了
                    for(int i=25;i>=1;i++){
                        BigDecimal temp=new BigDecimal(""+i);
                        if(now.equals(temp)){
                            now.divide(temp);
                            ans+=i;
                            break;
                        }else {
                            continue;
                        }
                    }
                }
            }
            if(flag==false){
                System.out.println(-1);
            }else {
                System.out.println(ans);
            }
        }
    }
}
