package leecode;

import common.ListNode;
import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/6/22 13:54
 * @Description TODO
 */
public class le24 {
    ListNode no;

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        no = head.next;

        ListNode frist = head;
        ListNode second = head.next;
        ListNode third = second.next;
        frist.next = third;
        second.next = frist;

        dfs(frist);

        return no;
    }

    private void dfs(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode frist = head;
        ListNode second = head.next;
        ListNode third = second.next;
        ListNode fourth = third.next;
        frist.next = third;
        third.next = second;
        second.next = fourth;
        dfs(second);
    }

    @Test
    public void t() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs(node);

    }
}
