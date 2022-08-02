package leecode;

import common.ListNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author hujf
 * @Date 2022/8/2 10:36
 * @Description TODO
 */
public class le82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode last = head;
        if(head==null){
            return head;
        }
        while (last!=null&&last.next != null) {
            boolean chongfu = false;
            while (last.next!=null&&last.next.val == last.val) {
                last.next = last.next.next;
                chongfu =true;
            }
            if(chongfu){
                last.val = 101;
            }
            last = last.next;
        }

        while (head!=null&&head.val==101){
            head = head.next;
        }

        last = head;
        while(last!=null&&last.next!=null){
            while(last.next!=null&&last.next.val == 101){
                last.next = last.next.next;
            }
            last=  last.next;
        }

        return head==null?  new ListNode():head;
    }

    @Test
    public void t() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);


        n1.next = n2;
        n2.next = n3;

        deleteDuplicates(n1);


    }
}
