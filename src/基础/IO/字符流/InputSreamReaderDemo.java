package 基础.IO.字符流;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author Hujf
 * @title: InputSreamReaderDemo
 * @date 2020/11/14 0014下午 7:22
 * @description: InputSreamReaderDemo
 */
public class InputSreamReaderDemo {

    @Test
    public void  InReader() throws Exception {
        //读入文件
        FileInputStream fis = new FileInputStream("src/基础/IO/字節流/hujf.txt");
        //得到字符流  字节流可以转字符流 ，但是字符流不能转字节流
        InputStreamReader isr = new InputStreamReader(fis);
        int n;
        while(( n=isr.read())!=-1){
            System.out.print((char)n);

        }
        isr.close();
    }


    //上诉方法效率低

    @Test
    public void  InReaders() throws Exception {
        //读入文件
        FileInputStream fis = new FileInputStream("src/基础/IO/字節流/hujf.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fis);

        BufferedReader buf = new BufferedReader(inputStreamReader);
        buf.readLine();
        char a[] = new char[1024];
        int n;
        while((n=inputStreamReader.read(a))!=-1){
            System.out.println(new String(a,0,n));
        }
    }


    @Test
    public void  InReaders2() throws Exception {
        //读入文件
        FileInputStream fis = new FileInputStream("src/基础/IO/字節流/hujf.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fis);

        BufferedReader buf = new BufferedReader(inputStreamReader);
        char a[] = new char[1024];
        int n;
        while((n=buf.read(a))!=-1){
            System.out.println(new String(a,0,n));
        }
    }


    @Test
    public void  InReadersLine() throws Exception {
        //读入文件
        FileInputStream fis = new FileInputStream("src/基础/IO/字節流/hujf.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fis);

        BufferedReader buf = new BufferedReader(inputStreamReader);
        String n;
        while(((n=buf.readLine()) !=null)){
            System.out.println(n);
        }
    }
}
