package learn.network.lesson2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemo01 {
    public static void main(String[] args) {

        ServerSocket serverSocket=null;
        Socket accept =null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;
        try {
            //需要有一个地址
            serverSocket = new ServerSocket(9999);
            while (true){
                //等待客户端连接进来
                accept = serverSocket.accept();
                //读取客户端的消息
                is = accept.getInputStream();
            /*暴力方法
            byte[] buffer = new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                String msg = new String(buffer, 0, len);
                System.out.println(msg);
            }
            * */

                //管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while((len=is.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源，先开后关
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(accept!=null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
