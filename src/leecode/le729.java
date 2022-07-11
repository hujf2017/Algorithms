package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/7/5 9:06
 * @Description TODO
 */
public class le729 {
    static Node node;
    static int  count =0;
    public le729() {

        node = new Node();
        node.val = -1;
    }

    public boolean book(int start, int end) {
        count++;
        return findindex(start, end,count);
    }

    private boolean findindex(int start, int end,int count) {
        Node k = node;
        while (k != null) {
            int val = k.val;
            int x = k.right == null ? (int) 1e9 : k.right.val;
            int flag = k.flag;
            int flag2 = k.right == null ? -1: k.right.flag;
            if (val <= start && x >= end&&flag!=flag2) {

                Node nodes = new Node();
                nodes.val = start;
                nodes.flag = count;
                Node node2 = new Node();
                node2.val = end;
                node2.flag = count;
                nodes.right = node2;
                Node xx = k.right;

                k.right = nodes;
                node2.right = xx;

                return true;
            }
            k = k.right;
        }
        return false;
    }


    class Node {
        int val;
        Node right;
        int flag;
    }


    @Test
    public void t() {
        le729 l = new le729();
        boolean book = l.book(592877997,609251496);
        boolean book1 = l.book(13, 22);
        boolean book2 = l.book(44, 50);
        boolean book3 = l.book(1, 7);
        boolean book4 = l.book(2, 10);
        boolean book5 = l.book(14, 20);
        boolean book6 = l.book(19, 25);
        boolean book7 = l.book(36, 42);
        boolean book8 = l.book(45, 50);
    }

}
