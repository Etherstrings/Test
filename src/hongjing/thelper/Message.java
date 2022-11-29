package hongjing.thelper;

import java.util.Date;

/**
 * @author Etherstrings
 * @create 2022-10-26 20:43 hongjing.thelper - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  Message - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/26 - the current system date.  20:43 - the current system time.  2022 - the current year.  10 - the current month.  26 - the current day of the month.  20 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class Message {
    //这条信息对应的Id
    String mid;
    //将每条信息转换为String类型的基础信息
    String mes;
    //发送时间
    Date date;
    //发送者
    String from;
    //接收者
    String to;
}
