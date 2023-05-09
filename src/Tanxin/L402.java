package Tanxin;

import meishengke.num;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-01 1:38 Tanxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L402 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/1 - the current system date.  1:38 - the current system time.  2023 - the current year.  03 - the current month.  01 - the current day of the month.  01 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L402 {
    public static void main(String[] args) {
        List<String> temp=new ArrayList<>();
        temp.add("null");
        temp.add("ths");
        temp.add("null");
        for(String str:temp){
            if("null".equals(str)){
                temp.remove(str);
            }
        }
        System.out.println(temp.get(0));
        System.out.println(minTime(new int[]{3,4},1,1));
    }

    public static int minTime(int[] worklist, int costTime, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int w : worklist) {
            pq.offer(w);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            n++;
            pq.offer(a * b);
            if (n % 2 == 1) {
                pq.offer(1);
            }
        }
        return pq.poll() * costTime;
    }



    public static String removeKdigits1(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        while(k>0){
            num=Integer.parseInt(num)+"";
            if(num.equals("0")){
                break;
            }
            if(num.length()==k){
                return "0";
            }
            for(int i=0;i<num.length();i++){
                if(i==num.length()-1){
                    num=num.substring(0,num.length()-1);
                    break;
                }
                if(num.charAt(i)>num.charAt(i+1)){
                    //删当前这个数
                    String left=num.substring(0,i);
                    String right=num.substring(i+1,num.length());
                    num=left+right;
                    break;
                }
            }
            if(num.equals("")){
                return "0";
            }
            num=Integer.parseInt(num)+"";
            k--;
        }
        return num;
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) idx = j;
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();
    }


}
