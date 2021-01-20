package 基础.NIO.File;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Hujf
 * @title: NioTest
 * @date 2021/1/19 0019下午 8:36
 * @description: TODO
 */
public class NioTest {
    public static void main(String[] args) {

        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("F:\\ziyuan\\[www.java1234.com]Java EE 7权威指南 卷1.pdf","rw");
            FileChannel channel = aFile.getChannel();
            //整个缓存区,分配空间
            ByteBuffer buf  = ByteBuffer.allocate(1024);
            //写入数据到Buffer
            int byteRead = channel.read(buf);
            System.out.print(byteRead);

            while(byteRead!=-1){
                //重置
                buf.flip();
                while(buf.hasRemaining()){
                    //从Buffer中读取数据
                    System.out.print((char)buf.get());
                }
                //调用clear()方法或者compact()方法
                buf.compact();
                byteRead = channel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(aFile!=null){
                try {
                    aFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
