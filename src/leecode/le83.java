package leecode;

import common.ListNode;
import org.junit.Test;

/**
 * @author Hujf
 * @title: le83
 * @date 2020/10/30 0030上午 10:04
 * @description: TODO
 */
public class le83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node =  head;
        while (node.next!=null){
            if(node.val==node.next.val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }

    @Test
    public void t(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        deleteDuplicates(node);
    }
}
