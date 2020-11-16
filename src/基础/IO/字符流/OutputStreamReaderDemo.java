package 基础.IO.字符流;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author Hujf
 * @title: OutputStreamReaderDemo
 * @date 2020/11/14 0014下午 7:49
 * @description: TODO
 */
public class OutputStreamReaderDemo {

    //
    @Test
    public void outPutReader1() throws Exception {
        FileOutputStream f = new FileOutputStream("src\\基础\\IO\\字符流\\output.txt");
        OutputStreamWriter ow = new OutputStreamWriter(f);
        String s = "asdasdasdasda";
        ow.write(s);
        ow.close();
    }


    @Test
    public void outPutReader2() throws Exception {
        //不覆盖
        FileOutputStream f = new FileOutputStream("src\\基础\\IO\\字符流\\output.txt",true);
        OutputStreamWriter ow = new OutputStreamWriter(f);
        String s = "asdasdasdasda1qw23";
        char a[] = s.toCharArray();
        ow.write(a);
        ow.close();
    }


    @Test
    public void outPutReader3() throws Exception {
        //不覆盖
        FileOutputStream f = new FileOutputStream("src\\基础\\IO\\字符流\\output.txt",true);
        OutputStreamWriter ow = new OutputStreamWriter(f);
        BufferedWriter bw = new BufferedWriter(ow);
        String s = "asdasdasdasda1qw23";
        bw.write(s);
        bw.close();
    }

}
