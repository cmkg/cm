import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;

public class Operation {
    public static void main(String[] args) {

/**1.登录，登录成功后运行答题系统**/
        login();
    }

    public static void exercise() {
        myframe f=new myframe();
    }

    /**2.答题系统**/
    static class myframe extends JFrame {
        JLabel L1 = new JLabel("运算算式：");
        JLabel L2 = new JLabel("请输入题目个数:");
        JLabel L3 = new JLabel("");
        JLabel L4 = new JLabel("       ");
        JLabel L5 = new JLabel("");
        JLabel L6 = new JLabel("欢迎使用！");
        JTextField T1 = new JTextField(15);
        JButton B1 = new JButton("开始");
        JButton B2 = new JButton("确认");
        JButton B3 = new JButton("下一题");
        JButton B4 = new JButton("颜色");
        JPanel p1 = new JPanel();
        int n = 0, a, b, c, d, j, k, l, m = 0, p;
        double result;
        char[] h = {'+', '-', '*', '/'}, h1 = {'(', ')', '!'};
        String s1, s2;

        myframe() {
            this.setTitle("四则运算系统");
            this.setSize(500, 400);//设置面板大小
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭子窗口
            this.add(p1);
            L1.setFont(new Font("幼圆", Font.BOLD, 16));
            L1.setForeground(Color.BLACK);
            L2.setFont(new Font("幼圆", Font.BOLD, 16));
            L3.setFont(new Font("幼圆", Font.BOLD, 12));
            L4.setFont(new Font("幼圆", Font.BOLD, 16));
            B1.setFont(new Font("幼圆", Font.BOLD, 15));
            B2.setFont(new Font("幼圆", Font.BOLD, 15));
            B3.setFont(new Font("幼圆", Font.BOLD, 15));
            B4.setFont(new Font("幼圆", Font.BOLD, 15));
            L6.setFont(new Font("华文行楷", Font.BOLD, 28));
            L6.setForeground(Color.BLACK);
            p1.setLayout(null);

            //运算算式
            L1.setBounds(130, 110, 140, 80);
            p1.add(L1);
            L4.setBounds(230, 110, 200, 80);
            p1.add(L4);

            //题目及答案输入
            L2.setBounds(130, 180, 130, 30);
            p1.add(L2);
            T1.setBounds(260, 180, 90, 30);
            p1.add(T1);
            L3.setBounds(100, 250, 50, 30);
            p1.add(L3);

            //提示
            L5.setBounds(130, 220, 180, 30);
            p1.add(L5);

            //欢迎使用
            L6.setBounds(180, 50, 180, 30);
            p1.add(L6);

            //各个按钮摆放的位置
            B2.setBounds(240, 280, 90, 40);//确认
            p1.add(B2);
            B2.setEnabled(false);
            B3.setBounds(150, 280, 90, 40);//下一题
            p1.add(B3);
            B3.setEnabled(false);
            B4.setBounds(330, 280, 90, 40);//换皮肤
            p1.add(B4);
            B1.setBounds(60, 280, 90, 40);//开始
            p1.add(B1);

            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);

            //按钮设置监听器
            B1.addActionListener(new B());
            B2.addActionListener(new B());
            B3.addActionListener(new B());
            B4.addActionListener(new B());
        }



        class B implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == B1)
                {
                    p = n = (int) Double.parseDouble(T1.getText());
                    //System.out.print(n);
                    if (n > 5 || n < 1) {
                        JOptionPane.showMessageDialog(null, "题目个数≥1, ≤5", "注意", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        B1.setEnabled(false);
                        B2.setEnabled(true);
                        B3.setEnabled(true);
                        L2.setText("你的答案 :");
                        L5.setText("答案不为空！");//设置文本
                        L5.setFont(new Font("幼圆", Font.BOLD, 12));
                        L5.setForeground(Color.magenta);
                        T1.setText(null);
                        star();
                    }
                }
                if (e.getSource() == B2)//确认按钮
                {
                    l = (int) Double.parseDouble(T1.getText());
                    if (l == result) {
                        m++;
                        s2 = "回答正确！";
                        L5.setText(s2);
                    } else {
                        s2 = "回答错误! 正确答案为:" + String.valueOf(result);
                        L5.setText(s2);
                    }
                    B2.setEnabled(false);
                }
                if (e.getSource() == B3)//下一题按钮
                {
                    if (n == 0) {
                        JOptionPane.showMessageDialog(null, "共答" + p + "题。答对题数为:" + m, "成绩统计", JOptionPane.INFORMATION_MESSAGE);
                        B1.setEnabled(true);
                        B2.setEnabled(false);
                        B3.setEnabled(false);
                        L2.setText("输入题目个数:");
                        L4.setText(null);
                        T1.setText(null);
                    } else {
                        L5.setText(null);
                        T1.setText(null);
                        star();
                        B2.setEnabled(true);
                    }
                }
                if (e.getSource() == B4)//换皮肤
                {
                    B4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent cc) {
                            Color ch = JColorChooser.showDialog(p1, "背景颜色",
                                    p1.getBackground());
                            if (ch != null) {
                                p1.setBackground(ch);
                                p1.repaint();
                            }
                        }
                    });
                }
            }
        }

        void star() {
            a = (int) (Math.random() * 200 - 100);
            b = (int) (Math.random() * 200 - 100);
            c = (int) (Math.random() * 200 - 100);
            d = (int) (Math.random() * 200 - 100);
            j = (int) (Math.random() * 4);
            k = (int) (Math.random() * 4);
            if (d < 0) {
                a = (int) (Math.random() * 9 + 1);
                s1 = String.valueOf(a) + String.valueOf(h1[2]);
                L4.setText(s1);
                result = 1;
                for (int i = 1; i <= a; i++)
                {
                    result = result * i;
                }
            } else {
                if (b >= 0 && c >= 0) {
                    s1 = String.valueOf(a) + String.valueOf(h[j]) + String.valueOf(b) + String.valueOf(h[k]) + String.valueOf(c);
                    L4.setText(s1);
                    System.out.println(s1);
                } else if (b < 0 && c >= 0) {
                    s1 = String.valueOf(a) + String.valueOf(h[j]) + String.valueOf(h1[0]) + String.valueOf(b) + String.valueOf(h1[1]) + String.valueOf(h[k]) + String.valueOf(c);
                    L4.setText(s1);
                    System.out.println(s1);
                } else if (b >= 0 && c < 0) {
                    s1 = String.valueOf(a) + String.valueOf(h[j]) + String.valueOf(b) + String.valueOf(h[k]) + String.valueOf(h1[0]) + String.valueOf(c) + String.valueOf(h1[1]);
                    L4.setText(s1);
                    System.out.println(s1);
                } else {
                    s1 = String.valueOf(a) + String.valueOf(h[j]) + String.valueOf(h1[0]) + String.valueOf(b) + String.valueOf(h1[1]) + String.valueOf(h[k]) + String.valueOf(h1[0]) + String.valueOf(c) + String.valueOf(h1[1]);
                    L4.setText(s1);
                    System.out.println(s1);
                }
                if (k > 1)
                {
                    if (k == 2) {
                        result = b * c;
                    } else if (k == 3) {
                        result = b / c;
                    }
                    if (j == 0) {
                        result = result + a;
                    } else if (j == 1) {
                        result = a - result;
                    } else if (j == 2) {
                        result = a * result;
                    } else if (j == 3) {
                        result = a / result;
                    }
                } else if (k < 2) {
                    if (j == 0) {
                        result = b + a;
                    } else if (j == 1) {
                        result = a - b;
                    } else if (j == 2) {
                        result = a * b;
                    } else if (j == 3) {
                        result = a / b;
                    }
                    if (k == 0)
                        result = result + c;
                    if (k == 1)
                        result = result - c;
                }
            }
            System.out.println(result);
            n--;
        }
    }

    /**3.登录跳转方法**/
    public static  void login(){
        // TODO Auto-generated method stub
        JFrame f=new JFrame();
        f.setTitle("四则运算系统登录界面");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);

        //设置窗口的大小和位置
        f.setSize(500,400);
        f.setLocation(420,120);

        Container con=f.getContentPane();//生成一个容器
        con.setLayout(new GridLayout(7,1));
        //生成一个新的版面
        JPanel pan1=new JPanel();
        JLabel title=new JLabel("欢迎登录四则运算系统！");
        title.setFont(new Font("幼圆",Font.BOLD, 20));
        pan1.add(title);
        con.add(pan1);

        //最上面的登陆文字
        //生成一个新的版面
        JPanel pan2=new JPanel();
        JLabel name=new JLabel("用户名");
        pan2.add(name);
        JTextField nameTest=new JTextField(15);
        pan2.add(nameTest);
        con.add(pan2);

        //生成一个新的版面
        JPanel pan3=new JPanel();
        JLabel pass = new JLabel("密    码");
        pan3.add(pass);
        JPasswordField password=new JPasswordField(15);
        password.setEchoChar('*');
        pan3.add(password);
        con.add(pan3);
        //密码及其密码域放在第三个版面上
        // System.out.println(username+"   "+userPassword);
        JPanel pan4 = new JPanel();
        JButton b_log=new JButton("登录");
        b_log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //获取用户名和密码，进行校验
                String myUsername=nameTest.getText();
                String myPassword=password.getText();
                if(myUsername.equals("chen")&&myPassword.equals("0081")){
                    JOptionPane.showMessageDialog(null, "登陆成功!");
                    exercise();
                    //				System.exit(0);
                }else{
                    JOptionPane.showMessageDialog(null, "账号或密码错误!");
                    nameTest.setText("");
                    password.setText("");
                }
            }
        });
        pan4.add(b_log);
        JButton b_exit=new JButton("退出");
        pan4.add(b_exit);
        con.add(pan4);
        JPanel pan5 = new JPanel();
        con.add(pan5);
        JPanel pan6 = new JPanel();
        con.add(pan6);
        JPanel pan7 = new JPanel();
        con.add(pan7);
    }
}


