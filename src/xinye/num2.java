package xinye;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-22 19:44 xinye - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/22 - the current system date.  19:44 - the current system time.  2022 - the current year.  09 - the current month.  22 - the current day of the month.  19 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static long[] commitTask(List<Step> steps) {
        //todo 请实现此函数
        Stack<Step> stack=new Stack<>();
        for(Step a:steps){
            if(stack.isEmpty()){
                stack.push(a);
            }else {
                //不为空
                if(stack.peek().getAction().equals(a.getAction())){
                    stack.push(a);
                }else {
                    if(stack.peek().getType()!=a.getType()){
                        stack.push(a);
                    }else {
                        stack.pop();
                    }

                }
            }
        }
        List<Long> ans=new ArrayList<>();
        for(Step a:stack){
            ans.add(a.getStepId());
        }
        Collections.reverse(ans);
        long[] t=new long[ans.size()];
        for(int i=0;i<ans.size();i++){
            t[i]=ans.get(i);
        }
        return t;
    }
    static class Step {
        //步骤id
        Long stepId;
        //步骤类型
        Long type;
        //动作 commit正向提交 cancel逆向撤销
        String action;

        public Step() {
        }

        public Long getStepId() {
            return stepId;
        }

        public void setStepId(Long stepId) {
            this.stepId = stepId;
        }

        public Long getType() {
            return type;
        }

        public void setType(Long type) {
            this.type = type;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }

    /**
     * 将输入的字符串任务步骤转换为步骤类的对象
     *【无需改动】
     *
     * @param stepStr
     * @return
     */
    private static Step convertToStep(String stepStr) {
        String cleanStep = stepStr.substring(1, stepStr.length() - 1);
        String[] vars = cleanStep.split(",");
        String[] stepIdStr = vars[0].split(":");
        String[] typeStr = vars[1].split(":");
        String[] actionStr = vars[2].split(":");
        Step step = new Step();
        step.setStepId(Long.parseLong(stepIdStr[1]));
        step.setType(Long.parseLong(typeStr[1]));
        step.setAction(actionStr[1]);
        return step;
    }

    /**
     * ACM模式输入输出处理【无需改动】
     *
     * @param args
     */
    public static void main(String[] args) {
        //ACM模式输入
        Scanner in = new Scanner(System.in);
        List<Step> strArr = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            strArr.add(convertToStep(in.nextLine()));
        }
        //题目逻辑计算
        long[] res = commitTask(strArr);
        //ACM模式输出
        System.out.println(Arrays.toString(res));
    }
}
