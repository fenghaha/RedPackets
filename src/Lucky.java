import java.util.Random;


class Lucky extends RedPackets {
    private int eachOne;//手气红包的抽的每一次金额
    int grabTime = -1;//抢红包的次数，与数组下标对应，初始值为-1

    private void setEachOne(int eachOne) {
        this.eachOne = eachOne;
    }

    private int getEachOne() {
        return eachOne;
    }

    Lucky() {
    }

    public void ask() {//与用户交互
        System.out.println("你选择了拼手气红包!!\n请输入红包个数(至少一个哦！！)");
        setNumber(scanner.nextInt());//输入个数
        System.out.println("请输红包总额(每个人至少分到0.01元哦！！)");
        setTotal(scanner.nextDouble());//输入总金额
        for (int i = 0; i < getNumber(); i++) {
            if (i == 0) {
                System.out.println("好了现在开始抢红包，请输入你的名字:");
                this.get(scanner.next());//抢第一次
            }
            if (i == getNumber() - 1) {//当抢到最后一个红包
                System.out.println("    红包已被抢完！！\n\n");
                this.show();
                System.out.println("      运气王是" + getTheLuckGuy(getMoney()) + "！！！\n");
                break;
            }
            System.out.println("请问还有人要抢红包吗？（请直接输入你的名字或者输入‘否’）");//是否继续抢
            String answer = scanner.next();
            if (isContinue(answer)) {//是否继续抢
                this.get(answer);
            } else {
                System.out.println("红包没人抢了！");
                break;
            }
        }
    }

    public void get(String name) {
        grabTime++;
        if (grabTime < getMoney().length - 1) {//前几次抢红包
            setEachOne(grabOnce(getRest()));
            setMoney(getEachOne(), grabTime);
            setPerson(name, grabTime);
            setRest(getRest() - getEachOne());
            System.out.printf("金额: %-15.2f" + name + "\n", getEachOne() / 100.0);
        } else if (grabTime == getMoney().length - 1) {//抢最后一次时直接输出余额
            setMoney(getRest(), grabTime);
            setPerson(name, grabTime);
            System.out.printf("金额: %-15.2f" + name + "\n", getRest() / 100.0);
        }
    }

    private int grabOnce(int theRest) {//抽一次小于剩余金额的随机红包
        Random random = new Random();
        boolean isCorrect = false;
        int r;
        do {
            r = random.nextInt(theRest) + 1;
            if (r > 0 && r < theRest && r <= getTotal() / 1.5) {
                isCorrect = true;
            }
        } while (!isCorrect);
        return r;
    }


    public String getTheLuckGuy(double arr[]) {//比较得出money数组中最大的一个
        double max = arr[0];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                j = i;
            }
        }
        return getPerson(j);//最后返回对应的名字，得到运气王
    }

    public void show() {//显示整个红包抢的情况
        for (int i = 0; i < getMoney().length; i++) {
            System.out.printf("金额: %-15.2f" + getPerson(i) + "\n", getMoney(i) / 100);
        }
    }
}
