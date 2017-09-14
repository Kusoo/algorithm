package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by l81022078 on 2017/8/2.
 */
public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(8888);
        while (true){
            Socket s = ss.accept();
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = in.read(buffer)) != -1){
                out.write(buffer, 0, len);
                out.flush();
            }
            s.close();
        }
    }
}
