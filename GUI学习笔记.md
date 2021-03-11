# GUI编程

组件

- 窗口
- 弹窗
- 面板
- 文本框
- 列表框
- 按钮
- 图片
- 监听事件
- 鼠标
- 键盘事件
- 破解工具



## 1、简介

------

GUI核心技术：Swing，AWT

1. 界面不美观
2. 需要jre环境

为什么要学习

1. 可以写自己的工具
2. 工作时候，也可能需要维护Swing界面，概率极小
3. 了解MVC架构，了解监听



## 2、AWT

-----

### 2.1 简介

new类 ，包含很多类和接口

核心类：Component

button, TextArea, Label

Container:Window, Panel

Window: Frame, Dialog

Panel: Applet



### 2.2 组件和容器

#### 1.frame

~~~java
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
~~~

问题，窗口关闭不掉



尝试封装

~~~java
package learn.gui.lesson1;

import java.awt.*;

public class TestFrame2 {
    public static void main(String[] args) {
        new MyFrame(100,100,200,200,Color.blue);
        new MyFrame(300,100,200,200,Color.yellow);
        new MyFrame(100,300,200,200,Color.gray);
        new MyFrame(300,300,200,200,Color.green);
    }
}
class MyFrame extends Frame{
    static int id=0;

    public MyFrame(int x,int y,int w,int h,Color color){
        super("MyFrame+"+(++id));
        setBackground(color);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
~~~


#### 2.面板panel

~~~java
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

~~~



#### 3.布局管理器









## 3、Swing

-----

