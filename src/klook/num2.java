package klook;

/**
 * @author Etherstrings
 * @create 2022-10-02 15:15 klook - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/2 - the current system date.  15:15 - the current system time.  2022 - the current year.  10 - the current month.  02 - the current day of the month.  15 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static char[][] Flick(char[][] matrix) {
        //请在这里实现算法并返回翻转后的结果
        int level=matrix.length;
        int col=matrix[0].length;

        for(int j=0;j<col;j++){
            finddeep(matrix,0,j);
            finddeep(matrix,level-1,j);
        }
        for(int i=0;i<level;i++){
            finddeep(matrix,i,0);
            finddeep(matrix,i,col-1);
        }

        for(int i=0;i<level;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='?'){
                    matrix[i][j]='O';
                }else if(matrix[i][j]=='O'){
                    matrix[i][j]='X';
                }
            }
        }
        return matrix;
    }

    public static void finddeep(char[][] matrix,int nlevel,int ncol){
        int level=matrix.length;
        int col=matrix[0].length;

        if(nlevel<0||ncol<0){
            return;
        }
        if(nlevel>=level||ncol>=col){
            return;
        }
        if(matrix[nlevel][ncol]!='O'){
            return;
        }
        matrix[nlevel][ncol]='?';
        finddeep(matrix,nlevel+1,ncol);
        finddeep(matrix,nlevel-1,ncol);
        finddeep(matrix,nlevel,col+1);
        finddeep(matrix,nlevel,col-1);

    }
}
