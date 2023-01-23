package Leetcode.week329;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Justice_wby
 * @create 2023-01-22 10:39
 */
public class num2 {

    public int[][] sortTheStudents(int[][] score, int k) {
        //第一行 代表 第一个学生在n场考试中的所有成绩
        //第一列 代表 第一场考试所有学生的成绩
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[k]-o1[k];
            }
        };
        Arrays.sort(score,(a,b)->b[k]-a[k]);
        return score;
    }
}
