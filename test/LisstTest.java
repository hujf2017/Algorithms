import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: LisstTest
 * @date 2020/12/2 0002下午 8:57
 * @description: TODO
 */
public class LisstTest {

    @Test
    public void t(){
        Deque<Integer> d = new LinkedList();
        int k  = d.peekLast();
        System.out.println(k);
    }

    @Test
    public void t2(){
        Deque<Integer> d = new LinkedList();
        int k  = d.peek();
        System.out.println(k);
    }
}
