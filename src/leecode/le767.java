package leecode;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Hujf
 * @title: le767
 * @date 2020/11/30 0030上午 9:09
 * @description: TODO
 */
public class le767 {
    public String reorganizeString(String S) {
        char[] ach = S.toCharArray();
        Map<Character, Integer> map = new TreeMap();
        for (char c : ach) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            int k = map.get(c);
            if (k - 1 > S.length() - k) {
                return "";
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        list.sort(Comparator.comparing(Map.Entry::getValue));
        list.sort((o1, o2) -> {
            //按照value值，用compareTo()方法默认是从小到大排序
            return o2.getValue().compareTo(o1.getValue());
        });
        StringBuilder sb = new StringBuilder();
        while (sb.length() < S.length()) {
            int i = 0;
            char a1 = 0;
            char a2 = 0;
            for (Map.Entry<Character, Integer> entry : list) {
                char c = entry.getKey();
                int num = entry.getValue();
                if (num > 0) {
                    switch (i) {
                        case 0:
                            a1 = c;
                            break;
                        case 1:
                            a2 = c;
                            break;
                        default:
                            break;
                    }
                    i++;
                    entry.setValue(entry.getValue() - 1);
                    if (i == 2) {
                        break;
                    }
                }
            }
            switch (i) {
                case 1:
                    sb.append(a1);
                    break;
                case 2:
                    sb.append(a1);
                    sb.append(a2);
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }

    @Test
    public void t() {
        reorganizeString("vvvlo");
    }
}
