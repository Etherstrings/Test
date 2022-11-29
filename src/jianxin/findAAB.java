package jianxin;

/**
 * @author Etherstrings
 * @create 2022-10-29 19:28 jianxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  findAAB - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/29 - the current system date.  19:28 - the current system time.  2022 - the current year.  10 - the current month.  29 - the current day of the month.  19 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class findAAB {
    public int count (String s) {
        // write code here
        String[] strs=s.split(" ");
        //最后一个为 len-1
        int len=strs.length;
        if(len<3){
            return 0;
        }else if(len==3){
            if(strs[0].equals(strs[1])&&!strs[0].equals(strs[2])){
                return 1;
            }else {
                return 0;
            }
        }
        int sum=0;
        for(int i=0;i<=len-3;i++){
            String now=strs[i];
            String next=strs[i+1];
            String last=strs[i+2];
            if(now.equals(next)&&!now.equals(last)){
                sum++;
                continue;
            }else {
                continue;
            }
        }
        return sum;
    }
}
