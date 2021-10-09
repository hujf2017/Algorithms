package 基础.链式编程测试;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: ArrayOb
 * @date 2021-09-13 10:56
 * @description: TODO
 */
public class ArrayOb {
    public static void main(String[] args) {
        System.out.println("getO1().add(\"1\") = " + getO1().add("1"));
    }

    private static List getO1() {
        ArrayList a = new ArrayList();
        a.add("");
        return a;
    }
}
