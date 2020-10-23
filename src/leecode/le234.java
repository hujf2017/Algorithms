package leecode;

import common.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hujf
 * @title: le234
 * @date 2020/10/23 0023上午 9:03
 * @description: TODO
 */
public class le234 {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> na = new LinkedList();
        ListNode a = head;
        while(a.next!=null){
            na.add(a);
            a =a.next;
        }
        na.add(a);
        ListNode b = head;
        while(na.size()>0){
            if(b!=na.pollLast()){
                return false;
            }
            b = b.next;
        }
        return true;
    }

    @Test
    public void t(){
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(1);
        isPalindrome(l);
    }
}
