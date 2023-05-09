package BoleGames;

/**
 * @author Etherstrings
 * @create 2023-02-23 14:00 BoleGames - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/23 - the current system date.  14:00 - the current system time.  2023 - the current year.  02 - the current month.  23 - the current day of the month.  14 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        int[] dirs=new int[]{0,1,1,2,3,4,0};
        int[] ans=GetLocation(4,4,2,3,dirs);
        System.out.println(ans[0]+" "+ans[1]);
    }
    public static int[] GetLocation (int m, int n, int x, int y, int[] dirs) {

        // write code here
        // 0<=x<m
        // 0<=y<n
        // 4 4
        // 取值范围为 0-m-1
        for(int todo:dirs){
            switch (todo){
                case 0:
                    break;
                case 1:
                    //往上走一个单位
                    if(y-1>=0){
                        y=y-1;
                    }
                    break;
                case 2:
                    //向右
                    if(x+1<n){
                        x=x+1;
                    }
                    break;
                case 3:
                    //向下
                    if(y+1<m){
                        y=y+1;
                    }
                    break;
                case 4:
                    //向左
                    if(x-1>=0){
                        x=x-1;
                    }
                    break;
            }
        }
        return new int[]{x,y};
    }
}
