package Leetcode.week329;

/**
 * @author Justice_wby
 * @create 2023-01-22 10:30
 */
public class num1 {
    public static void main(String[] args) {

    }
    public int alternateDigitSum(int n) {
        int ans=0;
        String num=n+"";
        for(int i=0;i<num.length();i++){
            if(i%2==0){
                ans+=(int)(num.charAt(i)-('0'));
            }else {
                ans-=(int)(num.charAt(i)-('0'));
            }
        }
        return ans;
    }
}
