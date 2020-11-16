import org.junit.Test;
import 比赛.OrderedStream;

/**
 * @author Hujf
 * @title: asdas
 * @date 2020/11/15 0015上午 10:57
 * @description: TODO
 */
public class asdas {
    @Test
    public void t() {
        OrderedStream o = new OrderedStream(9);
        o.insert(9, "fffff");
        o.insert(7, "ccccc");
        o.insert(6, "aaaaa");
        o.insert(4, "bbbbb");
        o.insert(2, "eeeee");
        o.insert(1, "ddddd");
        o.insert(5, "ggggg");
        o.insert(8, "hhhhh");
        o.insert(3, "mmmmm");
    }
}
