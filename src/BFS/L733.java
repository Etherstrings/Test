package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-02-27 13:08 BFS - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L733 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/27 - the current system date.  13:08 - the current system time.  2023 - the current year.  02 - the current month.  27 - the current day of the month.  13 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L733 {
    public static void main(String[] args) {
        int[][] image=new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(floodFill(image,1,1,2));
    }

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor == color) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }
}
