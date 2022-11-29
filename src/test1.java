import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-07-24 11:28 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  test1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/24 - the current system date.  11:28 - the current system time.  2022 - the current year.  07 - the current month.  24 - the current day of the month.  11 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class test1 {
    public static void main(String[] args) {
        test1 a=new test1();
        int[][] temp=new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[] test=new int[]{1,0,0,0,0,7,7,5};
        System.out.println(a.backspaceCompare("a#c","b"));

    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> str1=new Stack<>();
        Stack<Character> str2=new Stack<>();
        for(Character a:s.toCharArray()){
            if(str1.isEmpty()){
                if(a=='#'){
                    continue;
                }else {
                    str1.push(a);
                }
            }else {
                if(a=='#'){
                    str1.pop();
                }else {
                    str1.push(a);
                }
            }
        }

        for(Character a:t.toCharArray()){
            if(str2.isEmpty()){
                if(a=='#'){
                    continue;
                }else {
                    str2.push(a);
                }
            }else {
                if(a=='#'){
                    str2.pop();
                }else {
                    str2.push(a);
                }
            }
        }
        String strs="";
        String strt="";
        while(!str1.isEmpty()){
            strs+=str1.pop();
        }
        while(!str2.isEmpty()){
            strt+=str2.pop();
        }
        return strs.equals(strt);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int level=matrix.length;
        int col=matrix[0].length;
        if(matrix[0][0]>target){
            return false;
        }
        if(target>matrix[level-1][col-1]){
            return false;
        }
        boolean Flag=false;
        int i=0;
        int j=0;
        for(;j<col;j++){
            if(matrix[i][j]>target){
                j=j-1;
                break;
            }else if(matrix[i][j]==target){
                return true;
            }
        }
        if(j==col){
            j=j-1;
        }
        for(;i<level;i++){
            if(matrix[i][j]==target){
                Flag=true;
                break;
            }
        }
        return Flag;
    }

    public int edgeScore(int[] edges) {
        HashMap<Integer,Integer> Judge=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            //i是当前节点
            //edges[i]是指向的节点
            //判断是不是存在了指向节点的
            if(Judge.containsKey(edges[i])){
                Judge.put(edges[i],Judge.get(edges[i])+i);
            }else {
                Judge.put(edges[i],i);
            }
        }
        //节点--节点的最大值
        int max=-1;
        for(int i=0;i<edges.length;i++){
            //遍历节点 取最大值
            if(Judge.containsKey(i)){
                max=Math.max(max,Judge.get(i));
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            if(Judge.containsKey(i)){
                if(Judge.get(i)==max){
                    ans.add(i);
                }
            }

        }
        Collections.sort(ans);
        return ans.get(0);
    }

    public int equalPairs(int[][] grid){
        //将所有的列拼出来
        int level=grid.length;
        int row=grid[0].length;

        //String 次数
        HashMap<ArrayList<Integer>,Integer> Judge=new HashMap<>();

        for(int i=0;i<row;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<level;j++){
                temp.add(grid[j][i]);
            }
            if(Judge.containsKey(temp)){
                Judge.put(temp,Judge.get(temp)+1);
            }else {
                Judge.put(temp,1);
            }
        }
        int ans=0;
        //循环判断拼行
        for(int i=0;i<level;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<row;j++){
                temp.add(grid[i][j]);
            }
            if(Judge.containsKey(temp)){
                ans+=Judge.get(temp);
            }
        }
        return ans;
    }

    public String reformat(String s) {
        int num=0;
        int ch=0;
        List<Character> Num=new ArrayList<>();
        List<Character> Char=new ArrayList<>();
        for(char a:s.toCharArray()){
            if(Character.isLetter(a)){
                Char.add(a);
                ch++;
            }else {
                Num.add(a);
                num++;
            }
        }
        int diff=Math.max(num,ch)-Math.min(num,ch);
        if(diff!=0){
            if(diff!=1){
                return "";
            }
        }
        String ans="";
        if(num==ch){
            while(num>0){
                ans+=Num.get(num-1);
                ans+=Char.get(ch-1);
                num--;
                ch--;
            }
        }else if(num>ch){
            //先数字
            while (num>0){
                ans+=Num.get(num-1);
                num--;
                if(ch==0){
                    continue;
                }
                ans+=Char.get(ch-1);
                ch--;
            }

        }else if(num<ch){
            //先字母
            while(ch>0){
                ans+=Char.get(ch-1);
                ch--;
                if(num==0){
                    continue;
                }
                ans+=Num.get(ch-1);
                num--;
            }
        }
        return ans;

    }

    public int[][] largestLocal(int[][] grid) {
        int level=grid.length;

        int[][] ans=new int[level-2][level-2];

        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                ans[i][j]=getMax(grid,i,j);
            }
        }
        return ans;
    }

    int getMax(int[][] grid,int i,int j){
        int max=-1;
        for(int level=i;level<i+3;level++){
            for(int col=j;col<j+3;col++){
                max=Math.max(max,grid[level][col]);
            }
        }
        return max;
    }
}
