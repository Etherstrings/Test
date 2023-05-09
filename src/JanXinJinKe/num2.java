package JanXinJinKe;

/**
 * @author Etherstrings
 * @create 2023-04-08 19:30 JanXinJinKe - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/8 - the current system date.  19:30 - the current system time.  2023 - the current year.  04 - the current month.  08 - the current day of the month.  19 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        String str="1??10";
        System.out.println(maxDifferentPairs(str));
    }

    public static int maxDifferentPairs (String str) {
        // write code here
        char[] chars=str.toCharArray();
        back(chars,0,0);
        return ans;
    }
    public static int ans;
    public static void back(char[] chars,int index,int sum){
        if(index==chars.length){
            ans=Math.max(sum,ans);
            return;
        }
        for(int i=index;i<chars.length;i++){
            if(i==0){
                if(chars[i]=='?'){
                    chars[i]='1';
                    back(chars,i+1,sum);
                    chars[i]='?';

                    chars[i]='0';
                    back(chars,i+1,sum);
                    chars[i]='?';
                }
                continue;
            }
            if(chars[i]=='?'){
                chars[i]='0';
                if(chars[i]!=chars[i-1]){
                    sum=sum+1;
                }
                back(chars,i+1,sum);
                if(chars[i]!=chars[i-1]){
                    sum=sum-1;
                }
                chars[i]='?';

                chars[i]='1';
                if(chars[i]!=chars[i-1]){
                    sum=sum+1;
                }
                back(chars,i+1,sum);
                if(chars[i]!=chars[i-1]){
                    sum=sum-1;
                }
                chars[i]='?';
            }else {
                if(chars[i]!=chars[i-1]){
                    sum++;
                }
                back(chars,i+1,sum);
            }
        }
    }

    public static int maxDifferentPairs1(String str){
        int[][] dp=new int[str.length()+1][2];
        //存
        //不存
        if(str.charAt(0)=='?'){
            dp[0][0]=0;
            dp[0][1]=0;
        }
        return 5;
    }
}
