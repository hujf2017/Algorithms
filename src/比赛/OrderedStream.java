package 比赛;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le5601
 * @date 2020/11/15 0015上午 10:35
 * @description: 设计有序流
 */
public class OrderedStream {

    private static   int ptr=1;
    String []values;
    private int n;
    public OrderedStream(int n) {
        this.n = n;
        this.values = new String[n+1];
    }

    public List<String> insert(int id, String value) {
        values[id] = value;
        List<String> a = new ArrayList<String>();
        if(id==ptr){
            a.clear();
            for(int i=id;i<=n;i++){
                if(values[i]==null){
                    break;
                }
                ptr=i+1;
                a.add(values[i]);
            }
            return a;
        }else{
            a.clear();
            return a;
        }
    }

    @Test
    public void t(){
        OrderedStream o = new OrderedStream(9);
        o.insert(9,"fffff");
        o.insert(7,"ccccc");
        o.insert(6,"aaaaa");
        o.insert(4,"bbbbb");
        o.insert(2,"eeeee");
        o.insert(1,"ddddd");
        o.insert(5,"ggggg");
        o.insert(8,"hhhhh");
        o.insert(3,"mmmmm");
    }
}
