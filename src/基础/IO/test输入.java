package 基础.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Hujf
 * @title: test输入
 * @date 2020/11/27 0027下午 4:38
 * @description: TODO
 */
public class test输入 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(inputStream);
        while(buf.readLine()!=null){

        }
    }
}
