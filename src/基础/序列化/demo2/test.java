package 基础.序列化.demo2;

import 基础.序列化.demo1.C5_2_1;

import java.io.*;

/**
 * @author Hujf
 * @title: test
 * @date 2021-05-31 11:15
 * @description: TODO
 */
public class test {
    public static void main(String[] args) throws IOException {
        File file = new File("./C5_2_3.bin");
        if(file.exists()){
            ObjectInputStream osi = null;
            osi = new ObjectInputStream(new FileInputStream(file));
            try {
                C5_2_3 a = (C5_2_3) osi.readObject();
                System.out.println("a.getName() = " + a.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            C5_2_3 o1 = new C5_2_3("hujf222");

            ObjectOutputStream outputStream = null;

            try {
                outputStream = new ObjectOutputStream(new FileOutputStream(file));
                outputStream.writeObject(o1);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                outputStream.close();
            }
        }
    }
}
