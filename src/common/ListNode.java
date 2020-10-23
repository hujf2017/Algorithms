package common;

/**
 * @author Hujf
 * @title: ListNode
 * @date 2020/10/10 0010上午 9:45
 * @description: TODO
 */
public class ListNode {
    int val;
    public  ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
