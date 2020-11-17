package leecode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le155
 * @date 2020/11/17 0017下午 5:26
 * @description: TODO
 */
public class le155 {

    Deque<Integer> deque;

    Deque<Integer> dequefuzhu;

    /**
     * initialize your data structure here.
     */
    public le155() {
        this.deque = new LinkedList<>();
        this.dequefuzhu = new LinkedList();
        dequefuzhu.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        deque.add(x);
        dequefuzhu.add(Math.min(dequefuzhu.peek(), x));
    }

    public void pop() {
        deque.pollLast();
        dequefuzhu.pollLast();
    }

    public int top() {
        return deque.getLast();
    }
    //每次把最小的放到最上面
    public int getMin() {
       return  dequefuzhu.getLast();
    }
}
