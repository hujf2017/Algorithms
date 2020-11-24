package leecode;

import common.ListNode;
import org.junit.Test;

/**
 * @author Hujf
 * @title: le21
 * @date 2020/11/23 0023下午 2:29
 * @description: TODO
 */
public class le21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1, node2;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if (l1.val > l2.val) {
            node1 = l2;
            node2 = l2;
            l2=l2.next;
        } else {
            node1 = l1;
            node2 = l1;
            l1=l1.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node2.next = l2;
                l2 = l2.next;
            } else {
                node2.next = l1;
                l1 = l1.next;
            }
            node2 = node2.next;
        }
        if(l1==null){
            node2.next = l2;
        }else{
            node2.next =l1;
        }
        return node1;
    }

    @Test
    public void t(){
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
        mergeTwoLists(l2,l);
    }
}
