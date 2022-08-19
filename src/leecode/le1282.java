package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/8/12 9:14
 * @Description TODO
 */
public class le1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> x =new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            List<Integer> orDefault = map.getOrDefault(groupSizes[i], new ArrayList<>());
            orDefault.add(i);
            map.put(groupSizes[i],orDefault);
        }
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            Integer key = next.getKey();
            List<Integer> value = next.getValue();
            for(int i=0;i<value.size();i+=key){
                List a =new ArrayList();
                for(int j=0;j<key;j++){
                    a.add(value.get(i+j));
                }
                x.add(a);
            }
        }
        return x;
    }

    @Test
    public void t(){
        int[] ints = {2,1,3,3,3,2};
        groupThePeople(ints);
    }
}
