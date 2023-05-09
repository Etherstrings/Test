package Tanxin;

/**
 * @author Etherstrings
 * @create 2023-03-15 23:19 Tanxin - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  L2383 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/15 - the current system date.  23:19 - the current system time.  2023 - the current year.  03 - the current month.  15 - the current day of the month.  23 - the current hour.  19 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L2383 {
    public static void main(String[] args) {
        int[] energy={1,1,1,1};
        int[] experience={1,1,1,50};
        System.out.println(minNumberOfHours(1,1,energy,experience));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans=0;
        int esum=0;
        for(int n:energy){
            esum+=n;
        }
        if(initialEnergy<=esum){
            ans+=esum-initialEnergy+1;
        }
        for(int n:experience){
            if(initialExperience<=n){
                int target=n+1;
                ans+=target-initialExperience;
                initialExperience=target;
                initialExperience+=n;
            }else {
                initialExperience=initialExperience+n;
            }

        }
        return ans;
    }
}
