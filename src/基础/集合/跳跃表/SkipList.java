package 基础.集合.跳跃表;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Hujf
 * @title: SkipList
 * @date 2021-10-18 10:52
 * @description: 手动实现跳表
 */
public class SkipList<T> {

    private static final int MAX_LEVEL = 1 << 6;

    private SkipNode<T> top;
    private int level = 0;

    private Random random = new Random();

    public SkipList(SkipNode<T> top, int level, Random random) {
        this.top = top;
        this.level = level;
        this.random = random;
    }


    public SkipList() {
        this(4);
    }

    //初始化跳表 和头结点
    public SkipList(int level) {
        this.level = level;
        int i = level;

        SkipNode<T> tmp = null;
        SkipNode<T> prev = null;

        while (i-- != 0) {
            tmp = new SkipNode<T>(null, Double.MIN_VALUE);
            tmp.down = prev;
            prev = tmp;
        }
        //设置头节点  第0层
        top = tmp;
    }

    //随机产出节点高度   50%的概率
    public int getRandomLevel() {
        int lev = 1;
        System.out.println("random.nextInt() = " + random.nextInt());
        if (random.nextInt() % 2 == 0) {
            lev++;
        }
        return lev > MAX_LEVEL ? MAX_LEVEL : lev;
    }

    //增删改查

    public T get(double score) {
        SkipNode<T> t = top;
        while (t != null) {
            if (score == t.score) {
                return t.val;
            }

            if (t.next == null) {
                if (t.down != null) {
                    t = t.down;
                    continue;
                } else {
                    return null;
                }
            }
            //大于或者小于的情况  但是这样写会出现空指针报错  因为 当这个值 比所有的都大  t.next==null  就会空指针  所有加上上面的判断逻辑
            if (t.next.score > score) {
                t = t.down;
            } else {
                t = t.next;
            }
        }
        return null;
    }

    public void put(double score, T val) {
        //1，找到需要插入的位置
        SkipNode<T> t = top, cur = null;
        List<SkipNode<T>> path = new ArrayList<>();
        while (t != null) {
            if (t.score == score) {
                cur = t;
                break;
            }

            if (t.next == null) {
                path.add(t);
                if (t.down != null) {
                    t = t.down;
                    continue;
                } else {
                    break;
                }
            }

            if (t.next.score > score) {
                path.add(t);
                if (t.down == null) {
                    break;
                }
                t = t.down;
            } else {
                t = t.next;
            }

            if (cur != null) {
                while (cur != null) {
                    cur.val = val;
                    cur = cur.down;
                }
            } else {
                int lev = getRandomLevel();

                if (lev > level) {
                    SkipNode<T> temp = null;
                    SkipNode<T> prev = top;
                    while (level++ != lev) {
                        temp = new SkipNode<T>(null, Double.MIN_VALUE);
                        path.add(0, temp);//加到path的首部
                        temp.down = prev;
                        prev = temp;
                    }
                    top = temp;//头节点
                    level = lev;//level长度增加到新的长度
                }
                SkipNode<T> downTemp = null, temp = null, prev = null;
                System.out.println("当前深度为" + level + ",当前path长度为" + path.size());
                for (int i = level - 1; i >= level - lev; i--) {
                    temp = new SkipNode<T>(val, score);
                    prev = path.get(i);
                    temp.next = prev.next;
                    prev.next = temp;
                    temp.down = downTemp;
                    downTemp = temp;
                }
            }

        }
    }


    public void delete(double score) {
        SkipNode<T> t = top;
        while (t != null) {
            if (t.next == null) {
                t = t.down;
                continue;
            }

            if (t.next.score == score) {
                t.next = t.next.next;
                t = t.down;
                continue;
            }

            if (t.next.score > score) {
                t = t.down;
            } else {
                t = t.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SkipNode<T> t = top, next = null;
        while (t != null) {
            next = t;
            while (next != null) {
                sb.append(next.score + " ");
                next = next.next;
            }
            sb.append("\n");
            t = t.down;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SkipList<String> list = new SkipList<>();
        list.put(1.0, "1.0");
        System.out.println(list);
        list.put(2.0, "2.0");
        System.out.println(list);
        list.put(3.0, "3.0");
        System.out.println(list);
        list.put(4.0, "4.0");
        System.out.println(list);
        list.put(5.0, "5.0");
        list.put(6.0, "6.0");
        list.put(7.0, "7.0");
        list.put(8.0, "8.0");list.put(9.0, "9.0");


        System.out.println(list);
    }
}
