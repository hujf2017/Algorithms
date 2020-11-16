package 基础.IO.字節流;

import org.junit.Test;

import java.io.*;

/**
 * @author Hujf
 * @title: OutputStreamDemo
 * @date 2020/11/13 0013上午 11:52
 * @description: TODO
 */
public class OutputStreamDemo {

    @Test
    public void ot1() throws Exception {
        File file = new File("src\\基础\\IO\\字節流\\output.txt");
        FileOutputStream outputStream = new FileOutputStream(file,true);

        String test = "測試輸出dsafadggggggggggggggggfgdafgadfg　crtl+shift+f化繁为简111";
        byte[] butes = test.getBytes();
        outputStream.write(butes);
        outputStream.close();
    }

    @Test
    public void ot2() throws Exception {
        File file = new File("src\\基础\\IO\\字節流\\output.txt");
        FileOutputStream outputStream = new FileOutputStream(file,true);
        BufferedOutputStream b1 = new BufferedOutputStream(outputStream);
        for(int i=0;i<10000;i++) {

            b1.write(("hoho"+i).getBytes("UTF-8"));
        }
        b1.close();
    }
}
