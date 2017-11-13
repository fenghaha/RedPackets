public class Password extends Lucky {
    private String password;//口令

    Password() {
    }

    Password(double total, int number) {
        setTotal(total);
        setNumber(number);
    }

    @Override
    public void ask() {//与用户交互
        System.out.println("你选择了口令!!\n请设置口令: ");
        setPasssword(scanner.next());//设置口令
        System.out.println("请输入红包个数(至少一个哦)！！");
        setNumber(scanner.nextInt());//设置个数
        System.out.println("请输红包总额(每个人至少分到0.01元哦！！)");
        setTotal(scanner.nextDouble());//设置总金额
        for (int i = 0; i < getNumber(); i++) {
            if (i == 0) {
                System.out.println("好了现在开始抢红包，请输入你的名字:");
                String name = scanner.next();
                System.out.println(name + ", 请输入口令" + "\" " + getPasssword() + " \"来抢红包");
                isRight();
                this.get(name);//抢第一次
            }
            if (i == getNumber() - 1) {//当抢到最后一个红包
                System.out.println("    红包已被抢完！！\n\n");
                this.show();
                System.out.println("   运气王是" + getTheLuckGuy(getMoney()) + "！！！\n");
                break;
            }
            System.out.println("请问还有人要抢红包吗？（请直接输入你的名字或者输入‘否’）");//是否继续抢
            String answer = scanner.next();
            if (isContinue(answer)) {//是否继续抢
                System.out.println(answer + ", 请输入口令" + "\" " + getPasssword() + " \"来抢红包");
                isRight();
                this.get(answer);
            } else {
                System.out.println("红包没人抢了！");
                break;
            }
        }
    }

    private void setPasssword(String password) {
        this.password = password;
    }

    private String getPasssword() {
        return password;
    }

    private void isRight() {//判断口令是否正确
        String answer = scanner.next();
        while (!getPasssword().equals(answer)) {
            System.out.println("口令错误,请重新输入:");
            answer = scanner.next();
        }
    }

}
