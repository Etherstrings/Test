package tong58;

/**
 * @author Etherstrings
 * @create 2023-03-10 23:58 tong58 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num4 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/10 - the current system date.  23:58 - the current system time.  2023 - the current year.  03 - the current month.  10 - the current day of the month.  23 - the current hour.  58 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num4 {
    //223
    //AB
    //A想变小
    //B想变大
    //A先手 B后手
    //最后会变成什么？
    public static void main(String[] args) {
        System.out.println(changeNumber(223));
        System.out.println(changeNumber(9111000));
    }
    public static int changeNumber (int n) {
        // write code here
        // 奇数小
        // 偶数大
        String now=n+"";
        int[] nums=new int[now.length()];
        for(int i=0;i<now.length();i++){
            nums[i]=Integer.parseInt(now.charAt(i)+"");
        }
        boolean[] used=new boolean[n];
        int canuse=now.length();
        int times=1;
        boolean flag=true;
        while(flag){
            if(times%2==1){
                times++;
                if(canuse==0){
                    flag=false;
                    break;
                }
                //小红 希望变小
                //除了第一个开始 找到后续第一个不是0的数并且没有用过的数变为0
                for(int i=0;i<n;i++){
                    if(used[i]){
                        //已经被使用了
                        continue;
                    }
                    int num=nums[i];
                    if(i==0){
                        if(num==1){
                            //1变2
                            nums[i]=num+1;
                            used[i]=true;
                            canuse--;
                        }else {
                            nums[i]=1;
                            used[i]=true;
                            canuse--;
                        }
                        break;
                    }
                    if(num==0){
                        nums[i]=num+1;
                        used[i]=true;
                        canuse--;
                    }else if(num==1){
                        nums[i]=0;
                        used[i]=true;
                        canuse--;
                    }else {
                        nums[i]=0;
                        used[i]=true;
                        canuse--;
                    }
                    break;
                }
            }else {
                times++;
                //小紫 希望变大
                if(canuse==0){
                    flag=false;
                    break;
                }
                for(int i=0;i<n;i++){
                    if(used[i]){
                        //已经被使用了
                        continue;
                    }
                    int num=nums[i];
                    if(num==9){
                        nums[i]=8;
                        used[i]=true;
                        canuse--;
                    }else {
                        nums[i]=9;
                        used[i]=true;
                        canuse--;
                    }
                    break;
                }
            }
        }
        String ans="";
        for(int nownum:nums){
            ans+=nownum;
        }
        return Integer.parseInt(ans);
    }
}
