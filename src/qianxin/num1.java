package qianxin;

/**
 * @author Etherstrings
 * @create 2023-03-19 19:38 qianxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/19 - the current system date.  19:38 - the current system time.  2023 - the current year.  03 - the current month.  19 - the current day of the month.  19 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public int getWhiteCounts(int[][] rects) {
        int[][] canvas = new int[100][100];
        // 初始化画布为白色
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                canvas[i][j] = 0;
            }
        }
        // 执行画框操作
        for (int[] rect : rects) {
            int x1=rect[0];
            int y1=rect[1];
            int x2=rect[2];
            int y2=rect[3];
            int minx=Math.min(x1,x2);
            int maxx=Math.max(x2,x1);
            int miny=Math.min(y1,y2);
            int maxy=Math.max(y1,y2);
            for (int i = minx; i < maxx; i++) {
                for (int j = miny; j < maxy; j++) {
                    if(canvas[i][j]==0){
                        canvas[i][j]=1;
                    }else {
                        canvas[i][j]=0;
                    }
                }
            }
        }
        // 统计白色的数量
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (canvas[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
