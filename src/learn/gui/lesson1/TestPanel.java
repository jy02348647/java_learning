package learn.gui.lesson1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //布局的概念
        Panel panel = new Panel();

        //设置布局
        frame.setLayout(null);

        //坐标
        frame.setBounds(100,100,200,200);
        frame.setBackground(Color.red);

        //panel设置坐标，相对frame
        panel.setBounds(50,50,100,100);
        panel.setBackground(Color.gray);

        //frame.add(panel)
        frame.add(panel);

        frame.setVisible(true);

        //监听事件，监听窗口关闭事件 System.exit(0)
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //结束程序
                System.exit(0);
            }
        });
    }
}

