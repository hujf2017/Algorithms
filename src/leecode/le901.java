package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/10/21 9:12
 * @Description TODO
 */
public class le901 {
    private Deque<int[]> deque;
    int count;

    public le901() {
        deque = new ArrayDeque<>();
        deque.add(new int[]{-1,Integer.MAX_VALUE});
        count = -1;
    }

    public int next(int price) {
        count++;
        while (deque.peekLast()[1] <= price) {
            deque.pollLast();
        }
        int last = deque.peekLast()[0];
        deque.add(new int[]{count, price});
        return count - last;
    }


    @Test
    public void t() {
        le901 l = new le901();
        System.out.println(l.next(100));
        System.out.println(l.next(80));
        System.out.println(l.next(60));
        System.out.println(l.next(70));
        System.out.println(l.next(60));
        System.out.println(l.next(75));
        System.out.println(l.next(85));
    }
}
