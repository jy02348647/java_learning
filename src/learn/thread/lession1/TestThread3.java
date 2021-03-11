package learn.thread.lession1;

//创建线程方法2： 实现Runnable接口，重写run()方法，执行线程需要丢入runnable接口实现类，调用start
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        //run方法体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建runnable接口的实现类对象
        //创建线程对象，通过线程对象来开启线程，代理
        Thread thread = new Thread(new TestThread3());
        thread.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }
}
