package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/8/10 10:31
 * @Description TODO
 */
public class le692 {
    public List<String> topKFrequent(String[] words, int k) {

        Map <String,Integer>map = new HashMap();

        for(String s:words){

            Integer orDefault = map.getOrDefault(s, 0);
            map.put(s,orDefault+1);
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        List<NNode> a = new ArrayList();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();

            NNode nNode = new NNode(key,value);
            a.add(nNode);
        }
        Collections.sort(a);
        List<String> ax = new ArrayList();
        for(int i=a.size()-1;i>=0;i--){
            if(k<=0){
                break;
            }
            ax.add(a.get(i).name);
            k--;

        }

        return ax;
    }


    @Test
    public void t(){
        topKFrequent(new String[]{"the", "day", "as", "as","sunny", "the", "the", "the", "sunny", "as", "as"},4);
    }



}

class NNode implements Comparable<NNode>{
    String name ;
    int num;

    public NNode(String key, Integer value) {
        this.name = key;
        this.num = value;
    }


    @Override
    public int compareTo(NNode o) {
        if(num==o.num){
            return o.name.compareTo(this.name);
        }

        return num-o.num;
    }
}