package Leetcode.week329;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Justice_wby
 * @create 2023-01-22 10:48
 */
public class num3 {
    public boolean makeStringsEqual(String s, String target) {
        Set<Character> set=new HashSet<>();
        for(char n:s.toCharArray()){
            set.add(n);
        }
        boolean f=true;
        for(char n:target.toCharArray()){
            if(set.contains(n)){
                continue;
            }else {
                f=false;
                break;
            }
        }
        return f;
    }
}
