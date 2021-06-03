package 基础.序列化.demo1;

import java.io.*;

/**
 * @author Hujf
 * @title: TestSerializable
 * @date 2021-05-31 9:58
 * @description: TODO
 */
public class TestSerializable {

    public static void main(String[] args) throws IOException {
        File file = new File("./C5_1.bin");
        if(file.exists()){
          ObjectInputStream  osi = null;
          osi = new ObjectInputStream(new FileInputStream(file));
            try {
                C5_2_1 a = (C5_2_1) osi.readObject();
                System.out.println("a.getName() = " + a.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            C5_2_1.size = 10;
            C5_2_1 o1 = new C5_2_1("hujf");

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
