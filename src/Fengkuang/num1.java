package Fengkuang;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2023-04-23 11:13 Fengkuang - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/23 - the current system date.  11:13 - the current system time.  2023 - the current year.  04 - the current month.  23 - the current day of the month.  11 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        System.out.println(isTriangle("(55.9,68.4,80.8)(94.2,24.7,22.5)(12.5,53.0,59.9)"));
    }
    public static boolean isTriangle(String str) {
        String[] pointStrings = str.split("\\)\\s*\\(");
        double[][] points = new double[3][2];
        for (int i = 0; i < 3; i++) {
            String[] coords = pointStrings[i].replaceAll("[()]", "").split(",");
            points[i][0] = Double.parseDouble(coords[0]);
            points[i][1] = Double.parseDouble(coords[1]);
        }
        double[] distances = new double[3];
        distances[0] = distance(points[0], points[1]);
        distances[1] = distance(points[1], points[2]);
        distances[2] = distance(points[2], points[0]);
        Arrays.sort(distances);
        return distances[0] + distances[1] > distances[2];
    }

    private static double distance(double[] p1, double[] p2) {
        double dx = p1[0] - p2[0];
        double dy = p1[1] - p2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

}
