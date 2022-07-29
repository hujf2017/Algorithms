package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author hujf
 * @Date 2022/7/26 11:29
 * @Description TODO
 */
public class le1206跳表 {
    MySkipNode[] list = new MySkipNode[10];
    int level = 10;
    private Random random = new Random();

    public boolean getRandomLevel() {
        return random.nextInt(2) == 0;
    }


    public le1206跳表() {
    }

    MySkipNode he = new MySkipNode(-1);

    //找到节点再第几层 第几个
    public void findNum(int aim, MySkipNode[] ns) {
        MySkipNode cur = he;
        for (int i = level - 1; i >= 0; i--) {
            //找到这层比 需求值大的节点
            while (cur.thisNodeAllLevel[i] != null && cur.thisNodeAllLevel[i].val < aim) {
                cur = cur.thisNodeAllLevel[i];
            }
            //把每一层 比我这个小的   最近的一个值  即aim值 坐测的值  保留下来  存在这个ns数组中
            ns[i] = cur;
        }
    }


    public boolean search(int target) {
        MySkipNode cur = he;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.thisNodeAllLevel[i] != null && cur.thisNodeAllLevel[i].val < target) {
                cur = cur.thisNodeAllLevel[i];
            }
            if(cur.thisNodeAllLevel[0].val==target){
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        MySkipNode[] ns = new MySkipNode[level];
        findNum(num, ns);
        MySkipNode node = new MySkipNode(num);
        for (int i = 0; i < level; i++) {
            //第i层 比我小的最近一个的  bigger数组  就是我的数组
            node.thisNodeAllLevel[i] = ns[i].thisNodeAllLevel[i];
            //同时  我成为了 比我小的bgigger Node
            ns[i].thisNodeAllLevel[i] = node;
            if (!getRandomLevel()) {
                break;
            }
        }
    }

    public boolean erase(int num) {
        MySkipNode[] ns = new MySkipNode[level];

        MySkipNode cur = he;

        MySkipNode node = null;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.thisNodeAllLevel[i] != null && cur.thisNodeAllLevel[i].val < num) {
                cur = cur.thisNodeAllLevel[i];
            }
            if(cur.thisNodeAllLevel[0].val==num){
                node = cur.thisNodeAllLevel[0];
            }
        }

        //这个节点必须是 num 节点  如果不是 说明没有可以删除的节点
        if(node ==null||node.val!=num){
            return  false;
        }
        for (int i = 0; i < level; i++) {
            //可能出现数字相同的节点 但是 实际的对象并不相同
            if(ns[i].thisNodeAllLevel[i]==node){
                ns[i].thisNodeAllLevel[i] = ns[i].thisNodeAllLevel[i].thisNodeAllLevel[i];
            }
        }

        return true;
    }


    public static void main(String[] args) {
        le1206跳表 d = new le1206跳表();
        d.add(1);
        d.add(3);
        d.add(2);

        d.add(4);
        d.search(4);

    }


}

class MySkipNode {
    int val;
    //记录当前节点再每一层的next 节点
    MySkipNode[] thisNodeAllLevel = new MySkipNode[10];

    public MySkipNode(int num) {
        val = num;
    }
}