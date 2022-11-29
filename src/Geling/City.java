package Geling;

import lombok.Data;

/**
 * @author Etherstrings
 * @create 2022-09-20 0:28 Geling - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  City - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/20 - the current system date.  0:28 - the current system time.  2022 - the current year.  09 - the current month.  20 - the current day of the month.  00 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
@Data
public class City {
    private String cityname;
    private Integer cityId;
}
