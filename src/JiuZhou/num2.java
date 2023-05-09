package JiuZhou;

/**
 * @author Etherstrings
 * @create 2023-03-05 20:21 JiuZhou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/5 - the current system date.  20:21 - the current system time.  2023 - the current year.  03 - the current month.  05 - the current day of the month.  20 - the current hour.  21 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num2 {

    public static int getmin(int a,int b,int n){
        if(n<=2){
            //可以选a或者选b
            return Math.min(a,b);
        }else if(n==3){
            //3有几种组合？
            //a b
            //0 1
            //2 0
            return Math.min(2*a,b);
        }else if(n==4){
            //4有几种组合？
            //a b
            //0 2
            //1 1
            //2 0
            return Math.min(Math.min(2*b,a+b),2*a);
        }else {
            //根据2的选项进行比较
            //a b
            //0 2
            //1 1
            //2 1
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<=n/2;i++){
                int chosea=i*a;
                int choseb;
                if((n-(i*2))%3==0){
                    choseb=(n-(i*2))/3*b;
                }else {
                    choseb=((n-(i*2))/3+1)*b;
                }
                ans=Math.min(ans,chosea+choseb);
            }
            return ans;
        }

    }
}
