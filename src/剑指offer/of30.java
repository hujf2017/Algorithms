package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Hujf
 * @title: of30
 * @date 2020/9/22 0022下午 12:38
 * @description: TODO
 */
public class of30 {

    public of30() {
        minList.addFirst(Integer.MAX_VALUE);
    }

    private Queue<Integer> linkedBlockingQueue = new LinkedBlockingQueue();
    private Deque<Integer> minList=new LinkedList();

    public void push(int x) {
        if(x<minList.getFirst()){
            minList.addFirst(x);
        }
        linkedBlockingQueue.add(x);
    }

    public void pop() {
        linkedBlockingQueue.poll();
    }

    public int top() {
      return   linkedBlockingQueue.peek();
    }

    public int min() {
        return minList.getFirst();
    }

    public static void main(String args[]){
        int x = 3;
        of30 obj = new of30();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int param_4 = obj.min();
        obj.pop();
        int param_5 = obj.top();
        int param6 = obj.min();
    }
}
