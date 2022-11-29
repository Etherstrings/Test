package Yaxin;

/**
 * @author Etherstrings
 * @create 2022-09-29 14:47 Yaxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/29 - the current system date.  14:47 - the current system time.  2022 - the current year.  09 - the current month.  29 - the current day of the month.  14 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num3 {
        //潜伏期人数
        static long[] pre=new long[100];
        //潜伏期多少人发作
        static long[] P_F=new long[100];
        //发作期
        static long[] ill=new long[100];
        //新感染
        static long[] infect=new long[100];
        static long[] cure=new long[100];
        static long[] sickness=new long[100];
        public long countPatient (int days) {
            if(days<=6){
                return 1l;
            }
            for(int i=1;i<=6;i++){
                pre[i]=1;
                P_F[i]=0;
                ill[i]=0;
                infect[i]=0;
                cure[i]=0;
                sickness[i]=1;
            }
            int a=3;
            int b=4;
            //第14天开始有痊愈的
            for(int i=7;i<=12;i++){
                if(i==7){
                    P_F[i]=1;
                }else {
                    P_F[i]=0;
                }
                pre[i]=a;
                a=a+3;
                ill[i]=1;
                infect[i]=3;
                cure[i]=0;
                sickness[i]=b;
                b=b+3;
            }
            return days;
        }
}
