import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-03-31 14:35 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  WeiPai - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/31 - the current system date.  14:35 - the current system time.  2023 - the current year.  03 - the current month.  31 - the current day of the month.  14 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class WeiPai {
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(100010);
        lruCache.put(1,1);
        StringBuilder s=new StringBuilder("jidu");
        if((s.length()>10&&(s.append("auto").equals("True"))));
        System.out.println("result is "+s);
    }


    static class LRUCache {

        int count;

        Map<Integer,Integer> map;

        public LRUCache(int capacity) {

            map=new LinkedHashMap<>();

            count=capacity;

        }



        public int get(int key) {

            if(map.containsKey(key)){

                int value=map.get(key);

                map.remove(key);

                map.put(key,value);

                return map.get(key);

            }else{

                return -1;

            }

        }



        public void put(int key, int value) {

            if(map.containsKey(key)){

                map.remove(key);

                map.put(key,value);

                return;

            }

            if(count>0){

                map.put(key,value);

                count--;

            }else{

                int head=map.keySet().iterator().next();

                map.remove(head);

                map.put(key,value);

            }

        }

    }
}
