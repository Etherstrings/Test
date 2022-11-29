package now360;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-09 15:47 now360 - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/9 - the current system date.  15:47 - the current system time.  2022 - the current year.  09 - the current month.  09 - the current day of the month.  15 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
        //哈希map
            //long 存n
            String[] lin1spit=in.nextLine().split(" ");
            //棋子个数
            Long n=Long.parseLong(lin1spit[0]);
            //操作次数
            int q=Integer.parseInt(lin1spit[1]);
            //操作列表
            List<List<Long>> todolist=new ArrayList<>();
            for(int i=0;i<q;i++){
                String[] temps=in.nextLine().split(" ");
                List<Long> temp=new ArrayList<>();
                //加左
                temp.add(Long.parseLong(temps[0]));
                //加右
                temp.add(Long.parseLong(temps[1]));
                todolist.add(temp);
            }
            //对棋子赋初始值
            HashMap<Long,Integer> Qizi=new HashMap<>();
            //1黑
            //2白
            for(long i=1l;i<=n;i++){
                //所有的棋子设为黑
                Qizi.put(i,1);
            }
            //操作列表 todolist
            //棋子表示 Qizi
            //当前的棋子黑数量
            Long size=n;
            for(List<Long> temp:todolist){
                Long left=temp.get(0);
                Long right=temp.get(1);
                for(long i=left;i<=right;i++){
                    //从左往右
                    //所有的翻转
                    //黑1 白0
                    int show=Qizi.get(i);
                    if(show==1){
                        //黑变白
                        size--;
                        Qizi.put(i,0);
                    }else {
                        //白变黑
                        size++;
                        Qizi.put(i,1);
                    }
                }
                System.out.println(size);
            }

        }
    }

    public  void two(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            //哈希map
            //long 存n
            String[] lin1spit=in.nextLine().split(" ");
            //棋子个数
            Long n=Long.parseLong(lin1spit[0]);
            //操作次数
            int q=Integer.parseInt(lin1spit[1]);
            //操作列表
            List<List<Long>> todolist=new ArrayList<>();
            for(int i=0;i<q;i++){
                String[] temps=in.nextLine().split(" ");
                List<Long> temp=new ArrayList<>();
                //加左
                temp.add(Long.parseLong(temps[0]));
                //加右
                temp.add(Long.parseLong(temps[1]));
                todolist.add(temp);
            }
            //对棋子赋初始值
            int[] Qizi=new int[Math.toIntExact(n)];
            //全部赋值为黑
            Arrays.fill(Qizi,1);
            Long size=n;
            for(List<Long> temp:todolist){
                Long left=temp.get(0);
                Long right=temp.get(1);
                for(long i=left;i<=right;i++){
                    //从左往右
                    //所有的翻转
                    //黑1 白0
                    int show=Qizi[Math.toIntExact(i)];
                    if(show==1){
                        //黑变白
                        size--;
                        Qizi[Math.toIntExact(i)]=0;
                    }else {
                        //白变黑
                        size++;
                        Qizi[Math.toIntExact(i)]=1;
                    }
                }
                System.out.println(size);
            }


        }
    }
}
