public class Common extends RedPackets {
    private double single;//普通红包的单个金额
    Common() {
    }

    public void ask() {
        int number;//接收个数
        System.out.println("你选择了普通红包!!\n请输单个红包金额(至少0.01元哦)");
        single = scanner.nextDouble();
        setSingle(single);
        System.out.println("请输入红包个数(至少一个哦)");
        number = scanner.nextInt();
        setNumber(number);
        System.out.println("好了现在开始抢红包，请输入你的名字:");
        String name;
        name = scanner.next();
        this.get(name);//抢第一次

        for (int i = 1; i <= number; i++) {
            if (i == number) {//当抢到最后一个红包
                System.out.println("红包已被抢完！！");
                break;
            }
            System.out.println("请问还有人要抢红包吗？（请直接输入你的名字或者输入‘否’）");//是否继续抢
            String answer = scanner.next();
            if (isContinue(answer)) {
                this.get(answer);
            } else {
                System.out.println("红包没人抢了！");
                break;
            }
        }
    }

    public void get(String name) {
        System.out.println("金额：" + getSingle() + "元        " + name);
    }

    public void setSingle(double single) {
        if (single >= 0.01) {
            this.single = single;
        } else {
            System.out.println("别这么小气嘛，每个红包至少0.01哦");
            System.exit(1);
        }
    }

    public double getSingle() {
        return single;
    }
}