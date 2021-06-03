package 基础.序列化.demo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Hujf
 * @title: C5_2_3
 * @date 2021-05-31 10:58
 * @description: TODO
 */
public class C5_2_3 implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(name);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println("载重");
        name = (String) objectInputStream.readObject();
    }

    public C5_2_3(String name) {
        this.name = name;
    }
}
