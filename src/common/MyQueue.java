package common;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: MyQueue
 * @date 2020/11/18 0018下午 5:02
 * @description: TODO
 */
public class MyQueue {

    Deque<Integer> deque ;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.deque = new LinkedList();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        deque.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return deque.pollFirst();
    }

    /** Get the front element. */
    public int peek() {
       return deque.getFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return deque.size()==0;
    }
}
