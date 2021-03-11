package learn.network.lesson2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

//客户端
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket=null;
        OutputStream os=null;
        try {
            //需要知道服务端地址，端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port=9999;

            //创建socket连接
            socket = new Socket(serverIP,port);
            //发送消息
            os = socket.getOutputStream();
            os.write("welcome".getBytes());


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
