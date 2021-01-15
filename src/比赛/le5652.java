package 比赛;

import common.ListNode;
import org.junit.Test;

/**
 * @author Hujf
 * @title: le5652
 * @date 2021/1/10 0010上午 10:49
 * @description: TODO
 */
public class le5652 {
    public ListNode swapNodes(ListNode head, int k) {
        int frist = 1;
        ListNode a = head;
        ListNode b = head;
        while(frist<k){
            a = a.next;
            frist++;
        }
        ListNode c = a;
        while(c.next!=null){
            c=c.next;
            b=b.next;
        }
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
        return head;
    }


    @Test
    public void t(){
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        swapNodes(n,2);
    }

}
