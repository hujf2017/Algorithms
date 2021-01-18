package 基础.IO.字符流;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Hujf
 * @title: testIO
 * @date 2021/1/17 0017下午 2:16
 * @description: TODO
 */
public class testIO {

    @Test
    public void t() throws IOException {
        String File = "F:\\ziyuan\\nacos\\nacos\\data\\A.txt";
        //1.获取输出流
        FileOutputStream out = new FileOutputStream(File);
        String s = "sadasd";
        out.write(s.getBytes());
    }
}
