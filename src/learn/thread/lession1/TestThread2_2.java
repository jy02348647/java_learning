package learn.thread.lession1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2_2 implements Runnable{

    private String url;//网络图片地址
    private String name;//保存的文件名

    public TestThread2_2(String url,String name){
        this.url=url;
        this.name=name;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownleader2 webDownleader2 = new WebDownleader2();
        webDownleader2.downloader(url,name);
        System.out.println("下载了文件名为"+name);
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new TestThread2("https://pics4.baidu.com/feed/562c11dfa9ec8a139514f987e91cea89a0ecc075.jpeg?token=f9a9c6098631136639a9ec918927058c", "1.jpeg"));
        Thread t2 = new Thread(new TestThread2("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3d450%2c600/sign=30a25d46d3160924dc70aa1fe13719cc/f11f3a292df5e0fe1f7ab3115f6034a85edf72bb.jpg","2.jpg"));
        Thread t3 = new Thread(new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201609%2F15%2F20160915095008_sVHNf.thumb.700_0.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1618042629&t=8258a531a210dd840562832d40036f2a","3.jpeg"));

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownleader2{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            System.out.println("IO异常，downloader方法出现问题");
        }
    }


}
