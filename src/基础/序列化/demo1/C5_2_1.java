package 基础.序列化.demo1;

import java.io.Serializable;

/**
 * @author Hujf
 * @title: C5_2_1
 * @date 2021-05-31 9:57
 * @description: TODO
 */
public class C5_2_1 implements Serializable {


    static final long serialVersionUID =1L;
    private String name;
    static int size;

    public C5_2_1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
