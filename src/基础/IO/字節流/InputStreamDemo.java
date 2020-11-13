package 基础.IO.字節流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * @author Hujf
 * @title: InputStreamDemo
 * @date 2020/11/13 0013上午 10:34
 * @description: 字節流的問題
 *
 * 繼承自：InputStream
 *
 *
 */
public class InputStreamDemo {

    /**
     * FileInputStream 問題;
     * @throws Exception
     * 1.讀取一個字節
     *
     */
    @Test
    public void t1() throws Exception {
        System.out.println(new File(".").getAbsolutePath());
        File fileName = new File("src/基础/IO/字節流/hujf.txt");
      // File fileName = new File("src/基础/IO/字節流/hujf1.txt");
        //讀取文件  找不到就會拋出異常,
     //   FileInputStream a = new FileInputStream(fileName);
        FileInputStream input = new FileInputStream("src/基础/IO/字節流/hujf.txt");
        int  n=0;
        //讀入流之後查看輸出 每行的輸出
        StringBuffer sBuffer=new StringBuffer();
        //当n不等于-1,则代表未到末尾
        while (n!=-1)
        {
            //單個字節 太慢了 读取文件的一个字节(8个二进制位),并将其由二进制转成十进制的整数返回
            n=input.read();
            //转成字符
            char by=(char) n;
            sBuffer.append(by);
        }
        System.out.println(sBuffer.toString());
        input.close();
    }

    /**
     *  2.讀取一段
     * @throws Exception
     */
    @Test
    public void tN() throws Exception {
        FileInputStream input = new FileInputStream("src/基础/IO/字節流/hujf.txt");

        int n =0;
        StringBuffer sBuffer=new StringBuffer();
        //緩存數組 ，不至於一個個讀取 太慢
        byte buf[] = new byte[5];
        while((n=input.read(buf))!=-1){
            // while(n!=-1){
            //n=input.read(buf);
//            if(n==-1){
//                break;
//            }
          //  System.out.println(n);
           // System.out.println(Arrays.toString(buf));
            System.out.print(new String(buf,0,n));
          //  sBuffer.append(new String(buf,0,n));


        }
      //  System.out.println(sBuffer.toString());
        input.close();
    }
}
