import java.util.Scanner;

public class Grab extends RedPackets {
    public static void main(String[] args) {
        isForRedPackets();
        typeChoose();
        isWantAnother();
    }

    public static void isForRedPackets() {//判断用户是不是来发红包的
        Scanner scanner = new Scanner(System.in);
        String choice1;
        boolean correct = false;
        System.out.println("请问你是来发红包的吗？（回答是或否）");
        do {
            choice1 = scanner.next();
            if (choice1.equals("是")) {
                correct = true;
                break;
            } else if (choice1.equals("否")) {
                System.out.println("那拜拜咯~");
                System.exit(1);
            } else {
                System.out.println("请认真回答我的问题（回答是或否）！！");
            }
        } while (correct == false);
    }

    private static void typeChoose() {//选择红包类型的方法
        int choice2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("那请问你要发哪种红包呢？（请输入你选择的序号）\n1：普通红包\n2：手气红包\n3：口令红包");
        choice2 = scanner.nextInt();
        switch (choice2) {
            case 1:
                Common common = new Common();
                common.ask();
                break;
            case 2:
                Lucky lucky = new Lucky();
                lucky.ask();
                break;
            case 3:
                Password password = new Password();
                password.ask();
        }
    }

    public static void isWantAnother() {//还想再发一个吗？
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("请问您还想再发一个红包吗？？（是或否）");
            answer = scanner.next();
            if (answer.equals("是")){
                typeChoose();
            }
            else if(answer.equals("否")){
                System.exit(1);
            }
        } while (!answer.equals('是'));
    }
}