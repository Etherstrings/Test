package Tool.Yang2Lunar;

/**
 * @author Justice_wby
 * @create 2023-02-03 2:36
 */
/**
 * 中国日期转换
 将日期转换为干支纪年模式
 */
import java.util.*;
/**
 * 最常用的字符常量
 */
public class Main {
    public static void main(String[] args) {
        Date customDate=new Date(String.format("2022/12/13 18:39:00"));
        System.out.println("1.将当前日期转换为中式日期");
        System.out.println("2.将当前日期时间转换为简单日期时间");
        System.out.println("3.将当前日期时间转换为传统日期时间");
        System.out.println("4.将当前日期时间转换为完整日期时间");
        System.out.println(NewTimeTransfer.westernToChinese(customDate, TransferMode.日期).获取日期());

        System.out.println(NewTimeTransfer.westernToChinese(customDate, TransferMode.简单的日期时间).获取日期());

        System.out.println(NewTimeTransfer.westernToChinese(customDate, TransferMode.传统时期时间).获取日期());

        System.out.println(NewTimeTransfer.westernToChinese(customDate, TransferMode.完整的日期时间).获取日期());
    }
}
class ChineseConsts {
    public static char[] 天干={'癸','甲','乙','丙','丁','戊','己','庚','辛','壬'};
    public static char[] 地支={'亥','子','丑','寅','卯','辰','巳','午','未','申','酉','戌'};
    public static char[] 数字={'零','一','二','三','四','五','六','七','八','九','十'};

    public static char[] 时辰符号={'末','初'};
    public static Map<String,Integer[]> 取节气表(){
        Map<String,Integer[]> 节气表=new LinkedHashMap<>();
        节气表.put("小寒",new Integer[]{1,5});
        节气表.put("立春",new Integer[]{2,4});
        节气表.put("惊蛰",new Integer[]{3,6});
        节气表.put("清明",new Integer[]{4,5});
        节气表.put("立夏",new Integer[]{5,6});
        节气表.put("芒种",new Integer[]{6,5});
        节气表.put("小暑",new Integer[]{7,7});
        节气表.put("立秋",new Integer[]{8,8});
        节气表.put("白露",new Integer[]{9,7});
        节气表.put("寒露",new Integer[]{10,7});
        节气表.put("立冬",new Integer[]{11,7});
        节气表.put("大雪",new Integer[]{12,7});
        return 节气表;
    }

}
/**
 * 日期模式
 */
enum TransferMode {
    日期,简单的日期时间,传统时期时间,完整的日期时间
}
/**
 * 日期时间类
 */
class ChineseTime {
    private char 年干;
    private char 年支;
    private char 月干;
    private char 月支;
    private char 日干;
    private char 日支;
    private char 时辰;
    private char 时辰符号;
    private String 分钟;
    private String 秒;
    private TransferMode 模式;

    public char 取年干() {
        return 年干;
    }

    public void 设年干(char 年干) {
        this.年干 = 年干;
    }

    public char 取年支() {
        return 年支;
    }

    public void 设年支(char 年支) {
        this.年支 = 年支;
    }

    public char 取月干() {
        return 月干;
    }

    public void 设月干(char 月干) {
        this.月干 = 月干;
    }

    public char 取月支() {
        return 月支;
    }

    public void 设月支(char 月支) {
        this.月支 = 月支;
    }

    public char 取日干() {
        return 日干;
    }

    public void 设日干(char 日干) {
        this.日干 = 日干;
    }

    public char 取日支() {
        return 日支;
    }

    public void 设日支(char 日支) {
        this.日支 = 日支;
    }

    public char 取时辰() {
        return 时辰;
    }

    public void 设时辰(char 时辰) {
        this.时辰 = 时辰;
    }

    public char 取时辰符号() {
        return 时辰符号;
    }

    public void 设时辰符号(char 时辰符号) {
        this.时辰符号 = 时辰符号;
    }

    public String 取分钟() {
        return 分钟;
    }

    public void 设分钟(String 分钟) {
        this.分钟 = 分钟;
    }

    public String 取秒() {
        return 秒;
    }

    public void 设秒(String 秒) {
        this.秒 = 秒;
    }

    public TransferMode 取模式() {
        return 模式;
    }

    public void 设模式(TransferMode 模式) {
        this.模式 = 模式;
    }
    public String 获取日期(){
        switch (模式){
            case 传统时期时间:return String.format("%c%c年%c%c月%c%c日 %c时",年干,年支,月干,月支,日干,日支,时辰);
            case 日期:return String.format("%c%c年%c%c月%c%c日",年干,年支,月干,月支,日干,日支);
            case 完整的日期时间:
            case 简单的日期时间:return String.format("%c%c年%c%c月%c%c日 %c%c时%s分%s秒",年干,年支,月干,月支,日干,日支,时辰,时辰符号,分钟,秒);
            default:{
                System.out.println("未知的日期模式");
                return null;
            }
        }
    }
}
class ChineseNumberUtil {
    public static String numberToChinese(int number){
        StringBuffer stringBuffer=new StringBuffer();
        if (number<=10){
            return stringBuffer.append(ChineseConsts.数字[number]).toString();
        }else {
            int shi=number/10;
            int ge=number%10;
            if (shi==1&&ge==0){
                return stringBuffer.append(ChineseConsts.数字[10]).toString();
            }else if (shi==1){
                return stringBuffer.append(ChineseConsts.数字[10]).append(ChineseConsts.数字[ge]).toString();
            }else{
                return stringBuffer.append(ChineseConsts.数字[shi]).append(ChineseConsts.数字[10]).append(ChineseConsts.数字[ge]).toString();
            }
        }
    }
}
class DateUtil {
    public static int[] getWesternDate(Date date){
        int year = date.getYear() + 1900;
        int month=date.getMonth()+1;
        int day=date.getDate();
        int[] result={year,month,day};
        return result;
    }
    public static int[] getWesternTime(Date date){
        int hour = date.getHours();
        int minute=date.getMinutes();
        int second=date.getSeconds();
        int[] result={hour,minute,second};
        return result;
    }
}
/**
 * 日期转换类
 */
class NewTimeTransfer {
    /**
     * 以公历推算干支纪年，<br>
     * 符合传统的计算方法<br>
     * 传统计算方法中月份的推算是按照节令推算的<br>
     * 为了方便计算，规定每年各个节气的日期固定（正常情况下每年节气的日期是不固定的）
     * @param date 公历日期
     * @param mode 模式
     * @return 转换完的时间
     */
    public static ChineseTime westernToChinese(Date date, TransferMode mode){
        switch (mode){
            case 日期:return onlyDate(date);
            case 简单的日期时间:return simpleDateTime(date);
            case 传统时期时间:return traditionalDateTime(date);
            case 完整的日期时间:return fullDateTime(date);
            default: {
                System.out.println("模式不正确！");
                return null;
            }
        }
    }

    private static ChineseTime onlyDate(Date date){
        ChineseTime chineseTime=new ChineseTime();
        char[] 年干支 = 计算年干支(date);
        char[] 月干支 = 计算月干支(date,年干支[0]);
        char[] 日干支 = 计算日干支(date);
        return 设置时间(chineseTime, 年干支, 月干支, 日干支);
    }

    static ChineseTime 设置时间(ChineseTime chineseTime, char[] 年干支, char[] 月干支, char[] 日干支) {
        chineseTime.设年干(年干支[0]);
        chineseTime.设年支(年干支[1]);
        chineseTime.设月干(月干支[0]);
        chineseTime.设月支(月干支[1]);
        chineseTime.设日干(日干支[0]);
        chineseTime.设日支(日干支[1]);
        chineseTime.设模式(TransferMode.日期);
        return chineseTime;
    }

    private static char[] 计算日干支(Date date){
        int[] 月基数表={0,31,-1,30,0,31,1,32,3,33,4,34};
        int[] westernDate=DateUtil.getWesternDate(date);
        int 天干序列;
        int 世纪=westernDate[0]/100+1;
        int 世纪常数= (int) ((44*(世纪-17)+Math.floor((世纪-17)/4)+3)%60);
        int 公元年数后两位=westernDate[0]%100;
        int r=(公元年数后两位-1)/4*6+5*((公元年数后两位-1)/4*3+(公元年数后两位-1)%4)+月基数表[westernDate[1]-1]+westernDate[2]+世纪常数;
        if (westernDate[0]!=0&&westernDate[0]%4==0&&westernDate[0]%400!=0){
            r=r+1;
        }
        int 六十花甲子序数=r%60;
        天干序列=六十花甲子序数%10;
        if (天干序列==10){
            天干序列=0;
        }
        char 日干=ChineseConsts.天干[天干序列];
        int 地支序列=六十花甲子序数%12;
        if (地支序列==12){
            地支序列=0;
        }
        char 日支=ChineseConsts.地支[地支序列];
        return new char[]{日干,日支};
    }

    private static char[] 计算月干支(Date date,char 年干) {
        int[] westernDate=DateUtil.getWesternDate(date);
        int 天干索引 = 0;
        switch (年干){
            case '甲':
            case '己': {
                天干索引=3;
            };break;
            case '乙':
            case '庚': {
                天干索引=5;
            };break;
            case '丙':
            case '辛': {
                天干索引=7;
            };break;
            case '丁':
            case '壬': {
                天干索引=9;
            };break;
            case '戊':
            case '癸': {
                天干索引=1;
            };break;
        }
        int 地支索引=0;

        int 月=westernDate[1];
        int 日=westernDate[2];
        if (月==1&&日<5) {
            地支索引 = 1;
        }else if (月==2&&日<4||月==1){
            地支索引=2;
        }else{
            地支索引=3;
        }
        Map<String, Integer[]> 节气表 = ChineseConsts.取节气表();
        Set<String> strings = 节气表.keySet();
        Iterator<String> iterator = strings.iterator();
        int 节气索引=-1;
        Integer[] 节气日期=new Integer[2];
        while (iterator.hasNext()){
            if (节气索引+1==月-1){
                String next = iterator.next();
                Integer[] integers = 节气表.get(next);
                节气日期=integers;
                break;
            }else{
                节气索引++;
                iterator.next();
            }
        }
        if (日<节气日期[1]&&月>2){
            月=月-1;
        }
        if(月==1&&日<5){
            天干索引 += 10;
        }else if (月==1||(月==2&&日<4)){
            天干索引+=11;
        }else{
            if (月==2){
                地支索引+=月-2;
            }else{
                地支索引+=月-2;
                天干索引+=月-2;
            }
        }
        char 月干=ChineseConsts.天干[天干索引%10];
        char 月支=ChineseConsts.地支[地支索引%12];
        return new char[]{月干,月支};
    }

    private static char[] 计算年干支(Date date) {
        int[] westernDate = DateUtil.getWesternDate(date);
        Map<String, Integer[]> 取节气表 = ChineseConsts.取节气表();
        Integer[] 立春日期 = 取节气表.get("立春");
        if (westernDate[1]<立春日期[0]||westernDate[1]==立春日期[0]&&westernDate[2]<立春日期[1]){
            westernDate[0]-=1;
        }
        char 年干=ChineseConsts.天干[(westernDate[0]-3)%10];
        char 年支 = ChineseConsts.地支[(westernDate[0] - 3) % 12];
        return new char[]{年干,年支};
    }

    private static ChineseTime simpleDateTime(Date date){
        ChineseTime chineseTime = onlyDate(date);
        int[] westernTime = DateUtil.getWesternTime(date);
        char 时辰符号=ChineseConsts.时辰符号[westernTime[0]==0?0:westernTime[0]%2];
        int 数字时辰= (int) Math.ceil(westernTime[0]/2.0);
        if (数字时辰+1==13){
            数字时辰=0;
        }
        char 时辰=ChineseConsts.地支[数字时辰+1];
        chineseTime.设时辰符号(时辰符号);
        chineseTime.设时辰(时辰);
        chineseTime.设分钟(String.valueOf(westernTime[1]));
        chineseTime.设秒(String.valueOf(westernTime[2]));
        chineseTime.设模式(TransferMode.简单的日期时间);
        return chineseTime;
    }
    private static ChineseTime traditionalDateTime(Date date){
        ChineseTime chineseTime = simpleDateTime(date);
        chineseTime.设时辰符号('\u0000');
        chineseTime.设分钟(null);
        chineseTime.设秒(null);
        chineseTime.设模式(TransferMode.传统时期时间);
        return chineseTime;
    }
    private static ChineseTime fullDateTime(Date date){
        ChineseTime chineseTime = simpleDateTime(date);
        int[] westernTime = DateUtil.getWesternTime(date);
        chineseTime.设分钟(ChineseNumberUtil.numberToChinese(westernTime[1]));
        chineseTime.设秒(ChineseNumberUtil.numberToChinese(westernTime[2]));
        chineseTime.设模式(TransferMode.完整的日期时间);
        return chineseTime;
    }
}

