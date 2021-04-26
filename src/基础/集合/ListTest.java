package 基础.集合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: ListTest
 * @date 2021-04-2510:28
 * @description: TODO
 */
public class ListTest {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();

        for(int i=0;i<10;i++){
            a.add(i);
        }
        System.out.println(a.size());

        a.add(11);
    }
}
