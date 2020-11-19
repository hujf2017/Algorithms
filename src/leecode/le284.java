package leecode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le284
 * @date 2020/11/19 0019下午 7:49
 * @description: TODO
 */
public class le284 implements Iterator<Integer>{
    Deque<Integer> deque ;
    public le284(Iterator<Integer> iterator) {
        // initialize any member here.
        deque = new LinkedList<>();
        while (iterator.hasNext()) {
            deque.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return deque.getFirst();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return deque.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return deque.size()==0;
    }
}
