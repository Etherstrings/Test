package XianYu.DP_BFS;


import java.util.LinkedList;


/**
 * @author Etherstrings
 * @create 2023-02-16 14:53 XianYu - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  ChatGpt_num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/16 - the current system date.  14:53 - the current system time.  2023 - the current year.  02 - the current month.  16 - the current day of the month.  14 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
import java.util.*;
public class MBFS_num4{
    static class Node {
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    private static int n, m;
    private static char[][] maze;
    private static int[][] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            maze = new char[n][m];
            dist = new int[n][m];

            int startX = -1, startY = -1, endX = -1, endY = -1;
            for (int i = 0; i < n; i++) {
                String row = scanner.next();
                for (int j = 0; j < m; j++) {
                    maze[i][j] = row.charAt(j);
                    if (maze[i][j] == 's') {
                        startX = i;
                        startY = j;
                    } else if (maze[i][j] == 'd') {
                        endX = i;
                        endY = j;
                    }
                    dist[i][j] = Integer.MAX_VALUE; // 初始化dist为最大值
                }
            }

            int ans = bfs(startX, startY, endX, endY);
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
        scanner.close();
    }

    private static int bfs(int startX, int startY, int endX, int endY) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, 0));
        dist[startX][startY] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == endX && cur.y == endY) {
                return cur.step;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || maze[nextX][nextY] == '#') {
                    continue;
                }

                int step = cur.step + 1;
                if (maze[nextX][nextY] == 'c') {
                    int slideStep = slide(nextX, nextY, i);
                    if (slideStep != -1) {
                        step += slideStep;
                        nextX += dx[i] * slideStep;
                        nextY += dy[i] * slideStep;
                    } else {
                        continue;
                    }
                }

                if (step < dist[nextX][nextY]) {
                    dist[nextX][nextY] = step;
                    queue.offer(new Node(nextX, nextY, step));
                }
            }
        }

        return Integer.MAX_VALUE;
    }
    private static int slide(int startX, int startY, int direction) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int nextX = startX + dx[direction];
        int nextY = startY + dy[direction];
        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || maze[nextX][nextY] == '#') {
            return -1; // 如果冰面对面的格子不可达，则返回-1
        }
        if (maze[nextX][nextY] == 'd') {
            return 1; // 如果冰面对面的格子就是终点，则返回1
        }
        int slideStep = slide(nextX, nextY, direction); // 继续滑行
        if (slideStep == -1) {
            return -1; // 如果不能继续滑行，则返回-1
        }
        return slideStep + 1; // 返回总共滑行的步数
    }
}
