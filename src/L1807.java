import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Justice_wby
 * @create 2023-01-12 19:45
 */
public class L1807 {
    public static void main(String[] args) {
        //"(name)is(age)yearsold"
        //[["name","bob"],["age","two"]]
        String s="(name)is(age)yearsold";
        List<List<String>> knowledge=new ArrayList<>();
        List<String> temp1=new ArrayList<>();
        temp1.add("name");temp1.add("bob");
        List<String> temp2=new ArrayList<>();
        temp2.add("age");temp2.add("two");
        knowledge.add(temp1);knowledge.add(temp2);
        System.out.println(evaluate(s,knowledge));
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        //1.将knowledge转换为map
        //2.stack加入
        Map<String,String> map=new HashMap<>();
        for(List<String> now:knowledge){
            map.put(now.get(0),now.get(1));
        }
        String temp="";
        int left=0;
        boolean in=false;
        for(int i=0;i<s.length();i++){
            char now=s.charAt(i);
            if(now=='(') {
                left = i;
                in=true;
                continue;
            }

            if(now==')'){
                String nk=s.substring(left+1,i);
                if(map.containsKey(nk)){
                    temp+=map.get(nk);
                }else {
                    temp+="?";
                }
                in=false;
                continue;
            }
            if(in==true){
                continue;
            }else {
                temp+=now;
            }
        }
        return temp;
    }
}
