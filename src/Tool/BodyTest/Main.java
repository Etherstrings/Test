package Tool.BodyTest;

/**
 * @author Justice_wby
 * @create 2023-02-03 2:37
 */
import java.util.Scanner;

// juejin 当前不支持输入，且中文输出乱码，需移步编译器进行。
public class Main extends Common {
    public static void main(String[] args) {
        // 身体健康计算情况
        // 开始
        start();
        boolean flag = true;
        Person person = new Person();
        while (flag) {
            showRule();
            String inText = in();
            while (inText == null || inText == "") {
                show("输入错误，请检查是否有输入。");
                inText = in();
            }
            switch (inText) {
                case "0":
                    show("欢迎下次光临！");
                    flag = false;
                    break;
                case "1":
                    person.inName(); // 输入名字（如：南方者）
                    person.inSex(); // 输入性别
                    person.inAge(); // 输入年龄
                    person.inHeight(); // 输入身高
                    person.inWeight(); // 输入体重
                    person.inBust(); // 输入胸围
                    person.inWaist(); // 输入腰围
                    person.inHip(); // 输入臀围
                    break;
                case "2": // 显示`BMI`计算公式
                    showBMI();
                    break;
                case "3": // 计算`BMI`值
                    person.countBMI();
                    break;
                case "4": // 显示`体脂率值`计算公式
                    showBF();
                    break;
                case "5": // 计算`体脂率值`
                    person.countBF();
                    break;
                case "6":
                    person.display();
                    break;
                default:
                    show("输入错误，请检查是否有输入。");
            }

        }
    }

    public static void start() {
        show("********************************");
        show("计算身体健康情况");
        show("---------------------------------");
        show("说明：");
        show("1. 输入的参数值越多，计算标准越多。");
        show("2. 根据提示进入下一步。");
        show("（注：仅靠简单数据计算出的结果，都有可能的误差在8%以内；请以医院医生数据为标准。）");
        show("---------------------------------");
    }

    /**
     * 显示规则
     */
    public static void showRule() {
        show("---------------------------------");
        show("输入提示：0 退出；1 输入/修改参数；2 显示`BMI`计算公式；\n　　　　　3计算`BMI`值；4 显示`体脂率值`计算公式；5 计算`体脂率值`；6 输出个人情况；");
        show("---------------------------------");
    }

    /**
     * 体脂率情况
     */
    public static void showBF() {
        show("********************************");
        show("计算体脂率：1.2×BMI+0.23×年龄-5.4-10.8×性别（男1，女0）");
        show("---------------------------------");
        show("丨 类型 丨   体脂率范围");
        show("丨  男  丨   15%～18%");
        show("丨  女  丨   20%～30%");
        show("---------------------------------");
    }

    /**
     * 三围
     */
    public static void show3Point() {
        show("********************************");
        show("标准三围计算");
        show("-----------------------------------");
        show("丨 类型 丨     男    丨       女       ");
        show("丨 胸围 丨 身高×0.61 丨 身高×0.61×0.9  ");
        show("丨 腰围 丨 身高×0.42 丨 身高×0.42×0.89 ");
        show("丨 臀围 丨 身高×0.64 丨 身高×0.64×1.02 ");
        show("-----------------------------------");
    }

    public static void showBMI() {
        show("********************************");
        show("BMI 中国标准（计算公式：BMI = 体重（kg）/ 身高的平方（m）");
        show("---------------------------------");
        show("丨 分类 丨   BMI 范围     ");
        show("丨 偏瘦 丨   <= 18.4     ");
        show("丨 正常 丨 18.5 ~ 23.9  ");
        show("丨 过重 丨 24.0 ~ 27.9   ");
        show("丨 肥胖 丨   >= 28.0     ");
        show("---------------------------------");
    }

}

/**
 * 对应用户的类
 */
class Person extends Common {
    static String notInputText = "（待输入）";
    String name = "你"; // 姓名 默认称呼 “你”
    int age; // 年龄
    int sex = -1; // 性别（1男 0女）
    float height; // 体重
    float weight; // 身高
    float bmi; // BMI值
    float bust; // 胸围
    float waist; // 腰围
    float hip; // 臀围
    float canonBust; // 标准胸围
    float canonWaist; // 标准腰围
    float canonHip; // 标准臀围
    float bf; // 体脂率
    String text = "暂无";


    public void inName() {
        show("输入名字（如：南方者）");
        this.name = in();
    }


    public void inAge() {
        show("输入年龄");
        String str = in();
        while (!isNumber(str)) {
            show("输入格式错误，请检查。（格式：整数；如：18岁，输入18（多余小数会自动去掉）");
            str = in();
        }
        try {
            float f = Float.parseFloat(str);
            this.age = (int) f;
        } catch (Exception e) {
            show("输入错误，请重试。");
            this.inAge();
        }
    }


    public void inSex() {
        show("输入性别（男1 女0 其他为跳过）");
        String str = in();
        while (!isNumber(str)) {
            show("输入格式错误，请检查。（格式：整数；男1 女0");
            str = in();
        }
        try {
            float f = Float.parseFloat(str);
            if (f == 0 || f == 1) {
                this.sex = (int) f;
            }
        } catch (Exception e) {
            show("输入错误，请重试。");
            this.inSex();
        }
    }


    public void inHeight() {
        show("输入身高（输入0为跳过）");
        String str = in();
        while (!isNumber(str)) {
            show("输入格式错误，请检查。（格式为：数字；例如身高184cm，输入184）");
            str = in();
        }
        try {
            if (isZero(str)) {
                // 0为跳过
                return;
            }
            this.height = Float.parseFloat(str);
        } catch (Exception e) {
            show("输入错误，请重试。");
            this.inHeight();
        }
    }


    public void inWeight() {
        show("输入体重（输入0为跳过）");
        String str = in();
        while (!isNumber(str)) {
            show("输入格式错误，请检查。（格式为：数字；例如体重90.2kg，输入90.2）");
            str = in();
        }
        try {
            if (isZero(str)) {
                // 0为跳过
                return;
            }
            this.weight = Float.parseFloat(str);
        } catch (Exception e) {
            show("输入错误，请重试。");
            this.inWeight();
        }
    }


    public void inBust() {
        show("输入胸围（输入0为跳过）");
        String str = in();
        while (!isNumber(str)) {
            show("输入格式错误，请检查。（格式为：数字；例如胸围37.5，输入37.5）");
            str = in();
        }
        try {
            if (isZero(str)) {
                return;
            }
            this.bust = Float.parseFloat(str);
        } catch (Exception e) {
            show("输入错误，请重试。");
            this.inBust();
        }
    }


    public void inWaist() {
        show("输入腰围（输入0为跳过）");
        String str = in();
        while (!isNumber(str)) {
            show("输入格式错误，请检查。（格式为：数字；例如腰围50.5，输入50.5）");
            str = in();
        }
        try {
            if (isZero(str)) {
                return;
            }
            this.waist = Float.parseFloat(str);
        } catch (Exception e) {
            this.inWaist();
            show("输入错误，请重试。");
        }
    }


    public void inHip() {
        show("输入臀围（输入0为跳过）");
        String str = in();
        while (!isNumber(str)) {
            show("输入格式错误，请检查。（格式为：数字；例如臀围50.5，输入50.5）");
            str = in();
        }
        try {
            if (isZero(str)) {
                return;
            }
            this.hip = Float.parseFloat(str);
        } catch (Exception e) {
            this.inHip();
            show("输入错误，请重试。");
        }
    }

    /**
     * 计算 BMI
     */
    public void countBMI() {
        if (this.weight == 0 || this.weight < 1 || this.height < 1) {
            show("请检查当前的身高和体重是否有值。（计算 BMI 失败！");
            return;
        }
        this.bmi = this.weight / (this.height * this.height) * 100 * 100;  // 身高是以米为单位（因此，乘上两个100）
        show("计算成功！你的BMI值为：" + this.bmi);
    }

    /**
     * 计算标准三围
     */
    public void count3Point() {
        if (this.height == 0 || this.height < 1 || (this.sex != 0 && this.sex != 1)) {
            show("请检查当前的身高和性别是否有值。（计算标准三围失败！");
            return;
        }
        this.canonBust = this.height * 0.61f;
        this.canonWaist = this.height * 0.42f;
        this.canonHip = this.height * 0.64f;

        // 如果是女性，需要乘上对应的参数
        if (this.sex == 0) {
            this.canonBust *= 0.9f;
            this.canonWaist *= 0.89f;
            this.canonHip *= 1.02f;
        }
    }

    /**
     * 计算体脂率
     */
    public void countBF() {
        if (this.bmi == 0 || this.age == 0 || (this.sex != 0 && this.sex != 1)) {
            show("请检查当前的身高、体重、年龄、性别是否有值。（计算 体脂率 失败！");
            return;
        }
        this.bf = this.bmi * 1.2f + 0.23f * this.age - 5.4f - 10.8f * this.sex;
        show("计算成功！你的体脂率值为：" + this.bf);
    }

    public void display() {
//        countBMI();
//        count3Point();
//        countBF();
        // 输出身体情况
        String ageStr = "" + (this.age == 0 ? notInputText : this.age);
        String sexStr = this.sex == -1 ? notInputText : (this.sex == 1 ? "男" : "女");
        String heightStr = this.height == 0 ? notInputText : (this.height + "cm");
        String weightStr = this.weight == 0 ? notInputText : (this.weight + "kg");
        String bmiStr = this.bmi == 0 ? notInputText : this.bmi + "";
        String bfStr = this.bf == 0 ? notInputText : this.bf + "";
        show(this.name + "的身体情况");
        show("---------------------------------");
        show("丨  类型  丨   值");
        show("---------------------------------");
        show("丨  年龄  丨   " + ageStr);
        show("丨  性别  丨   " + sexStr);
        show("丨  身高  丨   " + heightStr);
        show("丨  体重  丨   " + weightStr);
        show("丨  BMI   丨   " + bmiStr);
        show("丨  体脂率 丨   " + bfStr);
        show("丨  最终建议：  " + this.text);
        show("---------------------------------");
    }

    public boolean isNumber(String str) {
        String regex = "\\d+(.\\d+)?";
        return str.matches(regex);
    }

    public static boolean isZero(String str) {
        return Float.parseFloat(str) == 0;
    }
}

class Common {
    /**
     * 仅为了方便输出
     *
     * @param str
     */
    public static void show(String str) {
        System.out.println(str);
    }

    /**
     * 输入
     *
     * @return
     */
    public static String in() {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        while (next == null || next.isEmpty() || next.trim().isEmpty()) {
            show("输入有误，请重新输入。");
            next = scanner.next();
        }
        return next;
    }
}


