//package 比赛;
//
//class LFUCache {
//
//    class Node {
//        int key;
//        int value;
//
//        Node left;
//        Node right;
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    int num;
//    Node head;
//    Node tail;
//
//    //建立头尾节点  双向链表
//    public LFUCache(int capacity) {
//        this.head = new Node(-1, -1);
//        this.tail = new Node(-1, -1);
//        head.right = tail;
//        tail.left = head;
//        this.num = capacity;
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//        Node node = new Node(key,value);
//        //如果没有达到最大值，那就找到最后一个插入
//        if(num>0){
//            //直接把这个节点放到最后就行了
//           Node node1 = head.right;
//            if(node1.key==-1){
//                head.right = node;
//                node.left = head;
//                node.right = tail;
//                tail.left = node;
//            }else{
//                while(node1.key!=-1){
//
//                }
//
//
//
//            }
//
//
//
//            num--;
//        }
//
//
//    }
//
//
//    public static void main(String[] args) {
//        LFUCache lfu = new LFUCache(2);
//        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//        lfu.get(1);      // 返回 1
//        // cache=[1,2], cnt(2)=1, cnt(1)=2
//        lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//        // cache=[3,1], cnt(3)=1, cnt(1)=2
//        lfu.get(2);      // 返回 -1（未找到）
//        lfu.get(3);      // 返回 3
//        // cache=[3,1], cnt(3)=2, cnt(1)=2
//        lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//        // cache=[4,3], cnt(4)=1, cnt(3)=2
//        lfu.get(1);      // 返回 -1（未找到）
//        lfu.get(3);      // 返回 3
//        // cache=[3,4], cnt(4)=1, cnt(3)=3
//        lfu.get(4);      // 返回 4
//        // cache=[3,4], cnt(4)=2, cnt(3)=3
//    }
//}
