package 比赛;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author hujf
 * @Date 2022/6/21 13:59
 * @Description TODO
 */
public class 是否成环 {
    public boolean hasCycle(String graph) {
        Map<String, HashSet> map = new HashMap<>();
        String[] split = graph.split(",");
        for(String s:split){
            String[] split1 = s.split("->");
            String start = split1[0];
            String end = split1[1];
            HashSet<String> orDefault = map.getOrDefault(end, new HashSet());
            orDefault.add(start);

            HashSet<String> orDefault1 = map.getOrDefault(start, new HashSet());
            for(String sx :orDefault1){
                orDefault.add(sx);
                orDefault.addAll(map.getOrDefault(sx,new HashSet()));
                if(orDefault.contains(end)){
                    return true;
                }
            }
            if(orDefault.contains(end)){
                return true;
            }
            map.put(end,orDefault);
        }

        return false;
    }

    @Test
    public void t(){
        hasCycle("1->1");
    }

}
