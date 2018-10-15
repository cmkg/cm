import java.util.Random;
import java.util.Scanner;

public class Count {

    public static void main(String[] args) {

        double right = 0;
        double wrong = 0;
        /*Scanner sc2 = new Scanner(System.in);
        int num2 = sc2.nextInt();*/
        for (int i = 0; i < 30; i++) {
            System.out.println("第"+(i+1)+"题,请在下方输入答案：");

            //生成三个随机数
            Random r1 = new Random();
            int x = r1.nextInt(100)+1;
            Random r2 = new Random();
            int y = r2.nextInt(100)+1;
            Random r3 = new Random();
            int z = r3.nextInt(100)+1;

            //生成随机运算符    + - * /
            Random r4 = new Random();
            int h = r4.nextInt(4);
            char[] chs = {'+','-','*','/'};
            String Operator = String.valueOf(chs[h]);

            //生成题目
            if(Operator.equals("+")){
                System.out.println(x+"+"+y+"-"+z+"=");
                boolean b = add(x,y,z);
                if(b == true){
                    right++;System.out.println("正确！ ");
                }else{
                    wrong++;System.out.println("错误！ ");
                }
                System.out.println("正确答案是： "+(x+y-z));

            }else if(Operator.equals("-")){
                System.out.println(x+"-"+y+"+"+z+"=");
                boolean b =minus(x,y,z);
                if(b == true){
                    right++;System.out.println("正确！ ");
                }else{
                    wrong++;System.out.println("错误！ ");
                }
                System.out.println("正确答案是："+(x-y+z));

            }else if(Operator.equals("*")){
                System.out.println(x+"×"+y+"/"+z+"=");
                boolean b =times(x,y,z);
                if(b == true){
                    right++;System.out.println("正确！ ");
                }else{
                    wrong++;System.out.println("错误！ ");
                }
                System.out.println("正确答案是： "+(x*y/z));
            }else{
                System.out.println(x+"÷"+y+"*"+z+"=");
                boolean b =divide(x,y,z);
                if(b == true){
                    right++;System.out.println("正确！ ");
                }else{
                    wrong++;System.out.println("错误！ ");
                }
                System.out.println("正确答案是： "+((float)x /(float) y * z));
            }
            System.out.println("-------------------------------");
        }
        System.out.println("您一共做对了"+right+"道题.");
        System.out.println("您一共做错了"+wrong+"道题.");
        if(wrong > 0){
            System.out.println("正确率为"+(right/(wrong+right))*100+"%");
        }else{
            System.out.println("答题完毕！");
        }
    }

    private static boolean add(int x,int y,int z) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int result = x + y -z;
        if(num1 == result){
            return true;
        }else{
            return false;
        }

    }
    private static boolean minus(int x,int y,int z) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int result = x - y + z;
        if(num1 == result){
            return true;
        }else{
            return false;
        }

    }
    private static boolean times (int x,int y,int z) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int result = x * y / z;
        if(num1 == result){
            return true;
        }else{
            return false;
        }

    }
    private static boolean divide(int x,int y,int z) {
        Scanner sc = new Scanner(System.in);
        float num1 = sc.nextFloat();
        float result =(float)x /(float) y  * z;
        if(num1 == result){
            return true;
        }else{
            return false;
        }

    }

}

