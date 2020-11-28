package 比赛;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hujf
 * @title: le5560
 * @date 2020/11/28 0028下午 10:58
 * @description: TODO
 */
public class FrontMiddleBackQueue {

    Deque<Integer> deque;
    public FrontMiddleBackQueue() {
        deque = new ArrayDeque();
    }

    public void pushFront(int val) {
        deque.addFirst(val);
    }

    public void pushMiddle(int val) {
        int num = deque.size();
        Deque<Integer> d = new ArrayDeque();
        int n =0;
        while(n<num/2){
            int num2 = deque.pollFirst();
            d.add(num2);
        }
        d.add(val);
        d.addAll(deque);
        deque =d;
    }

    public void pushBack(int val) {
        deque.addLast(val);
    }

    public int popFront() {
      return   deque.pollFirst();
    }

    public int popMiddle() {
        int num = deque.size();
        Deque<Integer> d = new ArrayDeque();
        int n =0;

        while(n<(num-1)/2){
            d.addFirst(deque.pollFirst());
        }
        int k=deque.pollFirst();
        d.addAll(deque);
        deque =d;
        return k;
    }

    public int popBack() {
        return deque.pollLast();
    }
}
