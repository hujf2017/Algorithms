package leecode;

import common.ListNode;

/**
 * @author Hujf
 * @title: le142
 * @date 2020/10/10 0010上午 9:35
 * @description: 链表成环 快慢指针
 */
public class le142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
//        while (fast != null) {
//            slow = slow.next;
//            if (fast.next != null) {
//                fast = fast.next.next;
//            } else {
//                return null;
//            }
//            if (fast == slow) {
//                ListNode ptr = head;
//                while (ptr != slow) {
//                    ptr = ptr.next;
//                    slow = slow.next;
//                }
//                return ptr;
//            }
//        }
        return null;
    }
}
