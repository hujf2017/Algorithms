package leecode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le116
 * @date 2020/10/15 0015下午 4:31
 * @description: TODO
 */
public class le116 {

    @Test
    public void t(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
         root =null;
        connect(root);
    }

    public Node connect(Node root) {
        if(root ==null){
            return root;
        }
        Deque<Node> q = new LinkedList();
        q.add(root);
        q.add(null);
        Node last = null;
        while(q.size()!=1){
            Node now = q.pollFirst();
            if(last==null){
                last = now;
            }else{
                last.next = now;
                last = now;
            }
            if(now==null){
                q.add(null);
            }
            if(now!=null&&now.left!=null) {
                q.add(now.left);
                q.add(now.right);
            }

        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
