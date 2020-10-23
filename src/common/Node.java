package common;

import java.util.List;

/**
 * @author Hujf
 * @title: Node
 * @date 2020/9/16 0016上午 10:07
 * @description: TODO
 */
public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
}
