package 剑指offer;

import common.ListNode;

/**
 * @author Hujf
 * @title: of22
 * @date 2021/1/20 0020上午 8:44
 * @description: TODO
 */
public class of22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode start = head;
        int i=0;
        while(i<k){
            start =start.next ;
            i++;
        }
        ListNode end = head;
        if(start==null){
            return head;
        }
        while(start.next!=null){
            start = start.next;
            end = end.next;
        }
        return end.next;
    }
}
