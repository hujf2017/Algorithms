package leecode;

import common.ListNode;

/**
 * @author Hujf
 * @title: le19
 * @date 2020/10/18 0018上午 9:25
 * @description: TODO
 */
public class le19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int first = 1;
        ListNode node1 = head;
        ListNode node2 = head;
        ListNode last = null;
        while(first<n){
            node1=node1.next;
            first++;
        }

        while(node1.next!=null){
            node1=node1.next;
            last =node2;
            node2 =node2.next;

        }
        if(last==null){
            head = head.next;
        }else {
            last.next = node2.next;
        }
        return head;
    }
}
