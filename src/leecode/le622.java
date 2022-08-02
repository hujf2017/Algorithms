package leecode;


import java.util.LinkedList;

/**
 * @Author hujf
 * @Date 2022/8/2 9:11
 * @Description TODO
 */
public class le622 {

    LinkedList<Integer> list;
    int k;

    public le622(int k) {
        list = new LinkedList();
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        return list.add(value);
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        list.removeFirst();
        return true;
    }

    public int Front() {
        return list.size()==0?-1:list.peekFirst();
    }

    public int Rear() {
        return list.size()==0?-1:list.peekLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public boolean isFull() {
        return list.size() == k;
    }

    public static void main(String[] args) {

        le622 le622 = new le622(3);
        le622.enQueue(1);
        le622.enQueue(2);
        le622.enQueue(3);
        le622.enQueue(4);
        le622.Rear();
    }

}
