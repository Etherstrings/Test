import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-08-29 19:40 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Now - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  19:40 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  19 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class Now {
    static Map<Integer,String> map;
    public static void main(String[] args) {
        map.put(1,"A");
        System.out.println(map.toString());
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String word=in.nextLine();
            String[] words = word.split(" ");
            String first=words[0];
            String end=words[1];
            //哪个列最大
            int col=Math.max(Integer.parseInt(first.substring(1,2)),Integer.parseInt(end.substring(1,2)));
            Character start=first.charAt(0);
            Character End=end.charAt(0);
            List<String> ans=new ArrayList<>();
            int index=1;
            for(int i=start;i<=End;i++){
                char temp=(char)i;
                if(index==1){
                    for(int j=Integer.parseInt(first.substring(1,2));j<=col;j++){
                        String now="";
                        now+=temp;
                        now+=j;
                        ans.add(now);
                    }
                    index++;
                    continue;
                }else {
                    for(int j=0;j<=col;j++){
                        String now="";
                        now+=temp;
                        now+=j;
                        ans.add(now);
                    }
                }
            }
            System.out.print("[");
            for(int i=0;i<ans.size();i++){
                if(i==ans.size()-1){
                    System.out.print(ans.get(i));
                    continue;
                }
                System.out.print(ans.get(i)+",");
            }
            System.out.print("]");
        }

    }

    public List<Integer> solution(int[] nums,int val) {
        HashMap<Integer,Integer> Judge=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        for(int a:nums){
            if(Judge.containsKey(a)){
                Judge.put(a,Judge.get(a)+1);
            }else{
                Judge.put(a,1);
            }
        }

        if(Judge.containsKey(val)){
            //能找到
            if(Judge.get(val)>1){
                for(int i=0;i<nums.length;i++){
                    if(nums[i]==val){
                        ans.add(i);
                    }
                }
                return ans;
            }else{
                //左闭右开
                //二分法
                int left=0;
                int right=nums.length;

                while(left<right){
                    int mid=left+(right+left)/2;
                    if(nums[mid]==val){
                        //找到了
                        ans.add(mid);
                        break;
                    }else if(nums[mid]>val){
                        //val在左边
                        //左闭 右开
                        right=mid;
                    }else if(nums[mid]<val){
                        left=mid+1;
                    }
                }
            }
        }else{
            //找不到
            ans.add(-1);
            return ans;
        }
        return ans;
    }

}
