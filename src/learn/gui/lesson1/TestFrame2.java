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