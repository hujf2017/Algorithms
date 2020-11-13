package 基础.IO.字節流;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
        byte[] butes = new byte[5];

        butes = test.getBytes();
        outputStream.write(butes);
        outputStream.flush();
        outputStream.close();
    }
}
