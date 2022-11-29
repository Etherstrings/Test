package Tuyou;

/**
 * @author Etherstrings
 * @create 2022-11-15 14:37 Tuyou - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/15 - the current system date.  14:37 - the current system time.  2022 - the current year.  11 - the current month.  15 - the current day of the month.  14 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {
        System.out.println(check(0,0,1,1,1,2,0.5f));
    }
    public static boolean check (float lineX1, float lineY1, float lineX2, float lineY2, float squareCenterX, float squareCenterY, float squareLength) {
        // write code here
        // 中点的x y
        // 正方形的边长
        // 转换为左上角 xy
        // 转换为右上角 xy
        float leftx=squareCenterX-squareLength/2;
        float lefty=squareCenterY+squareLength/2;

        float rightx=squareCenterX+squareLength/2;
        float righty=squareCenterY-squareLength/2;

        return isLineIntersectRectangle(lineX1,lineY1,lineX2,lineY2,leftx,lefty,rightx,righty);
    }

    private static boolean isLineIntersectRectangle(float linePointX1,
                                                    float linePointY1,
                                                    float linePointX2,
                                                    float linePointY2,
                                                    float rectangleLeftTopX,
                                                    float rectangleLeftTopY,
                                                    float rectangleRightBottomX,
                                                    float rectangleRightBottomY) {
        float lineHeight = linePointY1 - linePointY2;
        float lineWidth = linePointX2 - linePointX1;
        float t1 = lineHeight * rectangleLeftTopX + lineWidth * rectangleLeftTopY;
        float t2 = lineHeight * rectangleRightBottomX + lineWidth * rectangleRightBottomY;
        float t3 = lineHeight * rectangleLeftTopX + lineWidth * rectangleRightBottomY;
        float t4 = lineHeight * rectangleRightBottomX + lineWidth * rectangleLeftTopY;
        float c = linePointX1 * linePointY2 - linePointX2 * linePointY1;
        if ((t1 + c >= 0 && t2 + c <= 0)
                || (t1 + c <= 0 && t2 + c >= 0)
                || (t3 + c >= 0 && t4 + c <= 0)
                || (t3 + c <= 0 && t4 + c >= 0)) {
            if (rectangleLeftTopX > rectangleRightBottomX) {
                float temp = rectangleLeftTopX;
                rectangleLeftTopX = rectangleRightBottomX;
                rectangleRightBottomX = temp;
            }

            if (rectangleLeftTopY < rectangleRightBottomY) {
                float temp1 = rectangleLeftTopY;
                rectangleLeftTopY = rectangleRightBottomY;
                rectangleRightBottomY = temp1;
            }

            if ((linePointX1 < rectangleLeftTopX && linePointX2 < rectangleLeftTopX)
                    || (linePointX1 > rectangleRightBottomX && linePointX2 > rectangleRightBottomX)
                    || (linePointY1 > rectangleLeftTopY && linePointY2 > rectangleLeftTopY)
                    || (linePointY1 < rectangleRightBottomY && linePointY2 < rectangleRightBottomY)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
