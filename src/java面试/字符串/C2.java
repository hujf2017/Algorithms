package java面试.字符串;

import org.junit.Test;


/**
 * @author Hujf
 * @title: C2
 * @date 2021-06-08 16:15
 * @description: TODO
 */
public class C2 {
    Node frist;

    Node last;
    class Node{
        Object value;
        Node next;

        Node before;
        public Node(Object value){
            this.value = value;
        }
    }

    public void addNode(Node node){
        node.next = frist;
        if(frist!=null) {
            frist.before = node;
        }
        this.frist=node;

    }

    public void print(){
        Node node = this.frist;
        while(node!=null){
            System.out.print(node.value);
            node = node.next;
        }
    }

    public void reserve(){
        Node a = frist;
        while(a.next!=null){
            a = a.next;
        }
        while(a!=null){
            System.out.print(a.value);
            a = a.before;
        }
    }

    @Test
    public void test(){
        C2 c2 = new C2();
        Node a1 = new Node(1);
        c2.addNode(a1);
        Node a2 = new Node(2);
        c2.addNode(a2);
        c2.print();
        c2.reserve();
    }
}
