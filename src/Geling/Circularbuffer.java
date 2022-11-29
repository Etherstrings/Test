package Geling;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-20 0:38 Geling - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Circularbuffer - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/20 - the current system date.  0:38 - the current system time.  2022 - the current year.  09 - the current month.  20 - the current day of the month.  00 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Circularbuffer{
    private List<Object> list;
    private int length = 0;
    //用来取对应数据
    HashMap<Integer, Object> Objects = new HashMap<Integer, Object>();
    //构造器
    public Circularbuffer(int length) {
        this.length = length;
        this.list = new ArrayList<>();
    }
    //放入元素方法
    public void putElement(Object element) {
        //先进先出---放到末尾
        if(list.size()==0){
            list.add(element);
            this.Objects.put(1,element);
        }else {
            if(list.size()==length){
                //满了
                list.remove(0);
                list.add(element);
                //更新哈希map
                for(int i=0;i<list.size();i++){
                    this.Objects.put(i+1,list.get(i));
                }
            }else {
                list.add(element);
                Objects.put(list.size(),element);
            }
        }
    }
    public Object getElement(int index){
        //对应的i-size
        return Objects.get(index);
    }
    public boolean isfull(){
        return this.list.size()==length;
    }
    public void clear(){
        this.length=0;
        this.list=new ArrayList<>();
        this.Objects=new HashMap<Integer,Object>();
    }
}
