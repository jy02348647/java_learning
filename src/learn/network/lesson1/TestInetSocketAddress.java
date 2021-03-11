package learn.network.lesson1;

import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("localhost", 8080);
        System.out.println(inetSocketAddress);
        System.out.println(inetSocketAddress1);

        System.out.println(inetSocketAddress1.getAddress());
        System.out.println(inetSocketAddress1.getHostName());
        System.out.println(inetSocketAddress1.getPort());
    }
}
