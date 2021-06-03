package 基础.IO.BIO.single;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: BioCilent
 * @date 2021-05-31 19:03
 * @description: TODO
 */
public class BioCilent {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        OutputStream oss = socket.getOutputStream();

        String s = "123123";

        BufferedOutputStream buf =new BufferedOutputStream(oss);
        buf.write(s.getBytes(StandardCharsets.UTF_8));
        buf.close();
        socket.close();
    }
}
