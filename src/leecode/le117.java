package leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le117
 * @date 2020/9/28 0028上午 9:27
 * @description: TODO
 */
public class le117 {
    public Node connect(Node root) {
        Deque<Node> a = new LinkedList<>();
        a.add(root);
        a.add(null);
        Node last = null;
        while(a.size()>0){
            Node k =a.poll();
            if(k==null){
                if(a.size()>0) {
                    a.add(null);
                    last = null;
                    continue;
                }else{
                    continue;
                }
            }
            if(last!=null){
                last.next = k;
            }
            if(k.left!=null){
                a.add(k.left);
            }
            if(k.right!=null){
                a.add(k.right);
            }
            last = k;
        }

        return root;

    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
