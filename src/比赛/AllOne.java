package 比赛;

import org.junit.Test;

import java.util.*;

class AllOne {

    Map<String, Integer> map;
    Map<Integer, List<String>> map2;
    Map<String, Integer> mapIndex;

    Map<Integer,Integer> mapInt = new HashMap();

    public AllOne() {
        map = new HashMap();
        map2 = new HashMap<>();
        mapIndex = new HashMap<>();
    }

    int max = -1;
    int min = 50001;

    public void inc(String key) {
        int num = map.getOrDefault(key, 0) + 1;
        map.put(key, num);
        //找到那个数字所在的数组
        List<String> strings = map2.get(num - 1);
        //确保不是第0个map
        if (strings != null) {
            strings.remove((int)mapIndex.get(key));
            strings.add(mapIndex.get(key),null);
            mapInt.put(num - 1,mapInt.get(num-1)-1);

            if (mapInt.get(num-1)==0 && min == num - 1) {
                min=num;
            }
        }
        List<String> strings2 = map2.get(num);
        if (strings2 == null) {
            strings2 = new ArrayList();
            strings2.add(key);
        } else {
            strings2.add(key);

        }
        mapIndex.put(key, strings2.size() - 1);
        mapInt.put(num,mapInt.getOrDefault(num,0)+1);
        map2.put(num, strings2);
        if (num > max) {
            max = num;
        }
        if (num < min) {
            min = num;
        }
    }

    public void dec(String key) {
        int num = map.get(key) - 1;
        map.put(key, num);
        //找到那个数字所在的数组
        List<String> strings = map2.get(num + 1);
        //确保不是第0个map
        if (strings != null) {
            strings.remove((int)mapIndex.get(key));
            strings.add(mapIndex.get(key),null);

            mapInt.put(num + 1,mapInt.get(num+1)-1);
            if (mapInt.get(num+1) == 0 && max == num + 1) {
                max = num;
            }
        }
        List<String> strings2 = map2.get(num);
        if (strings2 == null) {
            strings2 = new ArrayList();
            strings2.add(key);
        } else {
            strings2.add(key);

        }
        mapIndex.put(key, strings2.size() - 1);
        mapInt.put(num,mapInt.getOrDefault(num,0)+1);
        map2.put(num, strings2);
        if (num > max) {
            max = num;
        }
        if (num < min) {
            min = num;
        }
    }

    public String getMaxKey() {
        if(max == -1){
            return "";
        }
        List<String> strings = map2.get(max);
        for(String s :strings){
            if(s!=null){
                return  s;
            }
        }
        return null;

    }

    public String getMinKey() {
        if(min == 50001){
            return "";
        }
        List<String> strings = map2.get(max);
        for(String s :strings){
            if(s!=null){
                return  s;
            }
        }
        return null;
    }

    @Test
    public static void main(String[] args){
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // 返回 "hello"
        System.out.println(allOne.getMinKey()); // 返回 "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // 返回 "hello"
        System.out.println(allOne.getMinKey()); // 返回 "leet"

    }
}
