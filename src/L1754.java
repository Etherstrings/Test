public class L1754 {
    public static void main(String[] args) {
        String word1="cabaa";
        String word2="bcaaa";
        System.out.println(largestMerge(word1,word2));
    }
    public static String largestMerge(String word1, String word2) {
        String ans="";
        boolean flag=true;
        if(word1.equals("")||word2.equals("")){
            return ans;
        }
        while(flag){
            char a=word1.charAt(0);
            char b=word2.charAt(0);
            if(a>b){
                word1=word1.substring(1,word1.length());
                if(word1.equals("")){
                    flag=false;
                }
                ans+=a;
            }else {
                word2=word2.substring(1,word2.length());
                if(word2.equals("")){
                    flag=false;
                }
                ans+=b;
            }
        }
        return ans;
    }
}
