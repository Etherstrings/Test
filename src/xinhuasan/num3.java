package xinhuasan;

/**
 * @author Etherstrings
 * @create 2022-10-18 20:34 xinhuasan - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/18 - the current system date.  20:34 - the current system time.  2022 - the current year.  10 - the current month.  18 - the current day of the month.  20 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        System.out.println(decryptString("24657980","123"));
    }

    public static String decryptString (String source, String key) {
        // write code here
        // 对source
        String ans="";
        int index=0;
        for(char a:source.toCharArray()){
            if(index==key.length()-1){
                //用到最后一位了
                //现在有的是什么?
                int c=Integer.parseInt(a+"");
                int k=Integer.parseInt(key.charAt(index)+"");
                //求P
                int p=c+10-k;
                if(p>10){
                    p=p-10;
                }
                ans+=p;
                //这里转换
                //下一回用0
                index=0;
                continue;
            }else {
                //现在有的是什么?
                int c=Integer.parseInt(a+"");
                int k=Integer.parseInt(key.charAt(index)+"");
                //求P
                int p=c+10-k;
                if(p>10){
                    p=p-10;
                }
                ans+=p;
                index++;
                continue;
            }
        }
        return ans;
    }
}
