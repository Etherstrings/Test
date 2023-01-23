/**
 * @author Justice_wby
 * @create 2023-01-23 18:34
 */
public class L2303 {
    public static void main(String[] args) {
        int[][] brackets={{3,50},{7,10},{12,25}};
        System.out.println(calculateTax(brackets,10));
    }

    public static double calculateTax(int[][] brackets, int income) {
        double ans=0l;
        int before=0;
        if(income==0){
            return ans;
        }
        for(int i=0;i<brackets.length;i++){
            int nowupper=brackets[i][0];
            double rate=(brackets[i][1])*(0.01);
            if(nowupper>=income){
                //上限比收入高了
                //10 7
                ans+=(income-before)*rate;
                break;
            }else {
                //上限比收入低
                //7
                //10
                ans+=(nowupper-before)*rate;
                before=nowupper;
            }
        }
        return ans;
    }
}
