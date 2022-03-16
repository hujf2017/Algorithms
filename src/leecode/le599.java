package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/3/14 15:48
 * @Description 找索引
 */
public class le599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> a = new ArrayList<>();
        int min = list1.length + list2.length;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int num = Math.min(list1.length, list2.length);
        for (int i = 0; i < num; i++) {
            if (list1[i].equals(list2[i])) {
                if (i + i < min) {
                    a.clear();
                    min = i + i;
                    a.add((list1[i]));
                } else if (i + i == min) {
                    a.add((list1[i]));
                }
                map1.put(list1[i], i);
                map2.put(list2[i], i);
            } else {
                map1.put(list1[i], i);
                map2.put(list2[i], i);
                if (map2.containsKey(list1[i])) {
                    if (i + map2.get(list1[i]) < min) {
                        a.clear();
                        min = i + map2.get(list1[i]);
                        a.add((list1[i]));
                    } else if (i + map2.get(list1[i]) == min) {
                        a.add((list1[i]));
                    }
                }
                if (map1.containsKey(list2[i])) {
                    if (i + map1.get(list2[i]) < min) {
                        a.clear();
                        min = i + map1.get(list2[i]);
                        a.add((list2[i]));
                    } else if (i + map1.get(list2[i])== min) {
                        a.add((list2[i]));
                    }
                }
            }
        }
        if (num == list1.length) {
            for (int i = num; i < list2.length; i++) {
                if (map1.containsKey(list2[i])) {
                    if (i + map1.get(list2[i]) < min) {
                        a.clear();
                        min = i + map1.get(list2[i]);
                        a.add((list2[i]));
                    } else if (i + map1.get(list2[i])== min) {
                        a.add((list2[i]));
                    }
                }
            }
        } else {
            for (int i = num; i < list1.length; i++) {
                if (map2.containsKey(list1[i])) {
                    if (i + map2.get(list1[i]) < min) {
                        a.clear();
                        min = i + map2.get(list1[i]);
                        a.add((list1[i]));
                    } else if (i + map2.get(list1[i]) == min) {
                        a.add((list1[i]));
                    }
                }
            }
        }
        String[] objects = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            objects[i] = a.get(i);
        }
        return objects;
    }


    @Test
    public void te() {
        String[] a1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] a2 = {"KFC","Shogun","Burger King"};
        findRestaurant(a1, a2);
    }

}
