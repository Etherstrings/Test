import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-08 20:22 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Wanmei1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/8 - the current system date.  20:22 - the current system time.  2022 - the current year.  09 - the current month.  08 - the current day of the month.  20 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Wanmei1 {
    public static void main(String[] args) {
        List<Item> itemList= new ArrayList<>();
        itemList.add(new Item("A",1));
        itemList.add(new Item("B",3));
        itemList.add(new Item("A",2));
        Map<String, Integer> confMap=new HashMap<>();
        confMap.put("A",10);
        confMap.put("B",10);
        List<Item> itemAddList=new ArrayList<>();
        itemAddList.add(new Item("A",5));
        itemAddList.add(new Item("B",10));
        itemAddList.add(new Item("B",3));
        Wanmei1 a=new Wanmei1();
        int capacity=3;
        List<Item> items = a.tryAddAndPack(itemList, itemAddList, confMap, capacity);
        for(Item v:items){
            System.out.println(v.toString());
        }
    }
    public List<Item> tryAddAndPack(List<Item> itemList, List<Item> itemAddList, Map<String, Integer> confMap, int capacity) {
        //TODO
        //容量是包裹的位置数---而不是大小数
        //相同key可以堆叠---堆叠后不一定能够再加进去
        //先整理背包
        itemList=sort(itemList,confMap);
        Set<String> nameset=new HashSet<>();
        for(Item now:itemList){
            nameset.add(now.name);
        }
        //挨个加入判断
        for(Item temp:itemAddList){
            //背包现在已经占了几个格子？
            int siez=itemList.size();
            //待加入的物品有几份？
            int num=temp.num;
            //遍历背包---查到最后一个是不是小于max
            //判断是不是新加入的物品
            Set<String> Judge=new HashSet<>();
            for(Item a:itemList){
                Judge.add(a.name);
            }
            if(Judge.contains(temp.name)){
                //不是新加入的
                int last=-1;
                int index=-1;
                for(int i=0;i<itemList.size();i++){
                    if(itemList.get(i).name.equals(temp.name)){
                        last=itemList.get(i).num;
                        index=i;
                    }
                }
                if(last!=confMap.get(temp.name)){
                    //背包这个位置还没有满
                    //判断能不能加入
                    if(last+temp.num<=confMap.get(temp.name)){
                        itemList.set(index,new Item(temp.name,last+temp.num));
                    }else {
                        //当前加进去 新加一个位置
                        if(siez<capacity){
                            //能加
                            //之前那个没满的位置设为满
                            itemList.set(index,new Item(temp.name,confMap.get(temp.name)));
                            //3+8-10
                            itemList.add(new Item(temp.name,last+temp.num-confMap.get(temp.name)));
                        }else {
                            //加不进去
                            return sort(itemList,confMap);
                        }
                    }
                }else {
                    //背包的最后一个位置是满的
                    //判断还有没有空位可以加
                    //可以加
                    if(siez<capacity){
                        itemList.add(new Item(temp.name,temp.num));
                    }else {
                        //加不进去了
                        return sort(itemList,confMap);
                    }
                }
            }else {

                //是新加入的
                //现在背包的容量
                int size=itemList.size();
                if(size<capacity){
                    //可以加
                    itemList.add(new Item(temp.name,temp.num));
                }else {
                    return sort(itemList,confMap);
                }
            }


        }

        return sort(itemList,confMap);



    }

    List<Item> sort(List<Item> itemList,Map<String, Integer> confMap){
        //先整理背包
        //背包里X有多少件
        HashMap<String,Integer> Judge=new HashMap<>();
        //有哪集样？
        Set<String> Nameset=new HashSet<>();
        for(Item temp:itemList){
            String name=temp.name;
            int num=temp.num;
            Nameset.add(name);
            if(Judge.containsKey(name)){
                Judge.put(name,Judge.get(name)+num);
            }else {
                Judge.put(name,num);
            }
        }
        //现根据名字排序
        List<String> sortname=new ArrayList<>();
        for(String name:Nameset){
            sortname.add(name);
        }


        Collections.sort(sortname);
        List<Item> bag=new ArrayList<>();
        for(String name:sortname){
            //按照名称大小依次排序
            //当前剩多少件
            int left=Judge.get(name);
            //一个堆叠的最大值是多少
            int max=confMap.get(name);
            while(left>0){
                if(left>=max){
                    Item now=new Item(name,max);
                    bag.add(now);
                    left=left-max;
                    Judge.put(name,Judge.get(name)-max);
                }else {
                    Item now=new Item(name,left);
                    bag.add(now);
                    left=0;
                    Judge.put(name,0);
                }
            }
        }
        return bag;
    }
}
