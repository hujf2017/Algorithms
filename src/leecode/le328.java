package leecode;

import common.ListNode;

/**
 * @author Hujf
 * @title: le328
 * @date 2020/11/13 0013上午 9:17
 * @description: TODO
 */
public class le328 {
    public ListNode oddEvenList(ListNode head) {
        if(head ==null){
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd  = head, even = evenHead;
        while(even !=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
