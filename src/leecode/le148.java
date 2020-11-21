package leecode;

import common.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hujf
 * @title: le148
 * @date 2020/11/21 0021上午 9:05
 * @description: TODO
 */
public class le148 {
    public  ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        List<ListNode> a = new ArrayList();
        while(head!=null){
            a.add(head);
            head = head.next;
        }
        List<ListNode> ax =a.stream().sorted(Comparator.comparingInt(x -> x.val)).collect(Collectors.toList());
        ListNode node2 = ax.get(0);
        for(int i=1;i<ax.size();i++){
            node2.next = ax.get(i);
            node2 = node2.next;
        }
        node2.next=null;
        return ax.get(0);
    }
    @Test
    public void t(){
        ListNode head  = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        sortList(head);
    }
}
