package 基础.集合.跳跃表;

/**
 * @author Hujf
 * @title: SkipNode
 * @date 2021-10-18 10:49
 * @description: TODO
 */
public class SkipNode<E> {
    E val;
    double score;
    //下一个指针 和  下一层
    SkipNode<E> next ,down;

    SkipNode(){

    }

    SkipNode(E val,double score){
        this.val = val;
        this.score =score;
    }
}
