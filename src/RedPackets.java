import java.util.Scanner;

public class RedPackets {
    public Scanner scanner = new Scanner(System.in);//给后面的输出用
    private double total;//红包总额（输入以元为单位的金额，再放大100倍，换算成分，避免浮点数的误差）
    private int number;//红包个数
    private double money[] = null;//存放所有红包金额的数组
    private String person[] = null;//存放抢红包的人的名字的数组
    private int rest;//存放每次抢红包后剩余的金额


    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
            initializeMoney(number);//顺便初始化金额数组的数组长度
        }
        else {
            System.out.println("Are you kiding??");
        }
    }

    public void setTotal(double total) {
        if (total >= 0.01 * number) {//判断总金额是否合法
            this.total = total * 100;
            rest = (int) getTotal();//初始化rest
        } else {
            System.out.println("老哥这点钱不够分啊！！！");
            System.exit(1);
        }
    }

    public void setMoney(double money, int n) {//对金额数组的单个元素设置
        this.money[n] = money;
    }

    public void setPerson(String person, int n) {//对人名数组的单个元素赋值
        this.person[n] = person;
    }

    public void setRest(int rest) {
        this.rest = (int) rest;
    }

    public void initializeMoney(int n) {//初始化money数组
        money = new double[number];
        person = new String[number];//顺便初始化人名数组
        rest = (int) getTotal();
    }

    public double getTotal() {
        return total;
    }

    public int getNumber() {
        return number;
    }


    public int getRest() {
        return rest;
    }

    public double getMoney(int i) {
        return money[i];
    }//得到money中的单个元素

    public double[] getMoney() {
        return money;
    }//得到整个money数组

    public String getPerson(int i) {
        return person[i];
    }
    public  static boolean isContinue(String answer){
        String choice;
       if (answer.equals("否")){
           return false;
       }
       else {
           return true;
       }
    }
}