package ComPartor;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-02-28 0:35 ComPartor - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L2363 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/28 - the current system date.  0:35 - the current system time.  2023 - the current year.  02 - the current month.  28 - the current day of the month.  00 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L2363 {
    public static void main(String[] args) {
        int[][] i1={{1,1},{4,5},{3,8}};
        int[][] i2={{3,1},{1,5}};
        System.out.println(mergeSimilarItems(i1,i2).size());
    }
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] it1:items1){
            map.put(it1[0],it1[1]);
        }
        List<List<Integer>> temp=new ArrayList<>();
        List<Integer> t;
        for(int[] it2:items2){
            if(map.containsKey(it2[0])){
                t=new ArrayList<>();
                t.add(it2[0]);
                t.add(map.get(it2[0])+it2[1]);
                temp.add(t);
                map.remove(it2[0]);
            }else {
                t=new ArrayList<>();
                t.add(it2[0]);
                t.add(it2[1]);
                temp.add(t);
            }
        }
        if(map.size()!=0){
            for(int k: map.keySet()){
                t=new ArrayList<>();
                t.add(k);
                t.add(map.get(k));
                temp.add(t);
            }
        }
        Comparator<List<Integer>> com=new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        };
        Collections.sort(temp,com);
        return temp;
    }
}
