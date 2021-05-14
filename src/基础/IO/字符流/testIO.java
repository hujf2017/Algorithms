package 基础.IO.字符流;

import org.junit.Test;

import java.io.*;

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

        FileInputStream out2 = new FileInputStream("sada.txt");
        //1.获取输出流
        FileInputStream out = new FileInputStream(File);
    }
}
