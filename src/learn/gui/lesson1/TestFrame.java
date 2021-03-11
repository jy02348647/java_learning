package learn.gui.lesson1;

import java.awt.*;

//GUI第一个界面
public class TestFrame {
    public static void main(String[] args) {

        Frame frame = new Frame("my first java frame window");

        //需要设置可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(400,400);

        //设置备件颜色
//        frame.setBackground(Color.black);
        frame.setBackground(new Color(113, 38, 123));

        //设置弹出初始位置
        frame.setLocation(200,200);

        //设置大小固定
        frame.setResizable(false);
    }
}
