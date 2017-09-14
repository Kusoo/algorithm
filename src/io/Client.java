package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by l81022078 on 2017/8/2.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getLocalHost(), 8888);
        OutputStream out = s.getOutputStream();
        InputStream in = s.getInputStream();

        out.write("ping".getBytes());
        s.shutdownOutput();
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[1024];
        int len = 0;
//        while((len = in.read(buffer)) != -1){
//            String str = new String(buffer, 0, len, "UTF-8");
//            sb.append(str);
//        }
        len = in.read(buffer);
        String str = new String(buffer, 0, len, "UTF-8");
        sb.append(str);
        System.out.println(sb.toString());
    }
}
