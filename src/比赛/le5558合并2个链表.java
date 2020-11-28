package 比赛;

import common.ListNode;
import org.junit.Test;

/**
 * @author Hujf
 * @title: le5558合并2个链表
 * @date 2020/11/28 0028下午 10:45
 * @description: TODO
 */
public class le5558合并2个链表 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i=0;
        ListNode node = list1;
        while(i<a-1){
            list1 =list1.next;
            i++;
        }
        ListNode node2 = list1;

        while(i<=b){
            list1 = list1.next;
            i++;
        }
        node2.next = list2;
        while(list2.next!=null){
            list2 = list2.next;
        }
        list2.next = list1;
        return node;
    }

    @Test
    public void t(){
        ListNode n = new ListNode(0);
        n.next = new ListNode(1);
        n.next.next =new ListNode(2);
        n.next.next.next = new ListNode(3);
        n.next.next.next.next = new ListNode(4);
        n.next.next.next.next.next = new ListNode(5);

        ListNode n1 = new ListNode(6);
        mergeInBetween(n,3,4,n1);
    }
}
