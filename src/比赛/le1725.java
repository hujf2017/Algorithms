package 比赛;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Hujf
 * @title: le1725
 * @date 2021/1/21 0021上午 9:07
 * @description: TODO
 */
public class le1725 {
    public int countGoodRectangles(int[][] rectangles) {
        Map map = new HashMap<>();
        for(int []a:rectangles){
            int min = Math.min(a[0],a[1]);
            int k= (int) map.getOrDefault(min,0);
            map.put(min,++k);
        }

        int max = 0;
        int count=0;
        Iterator<Map.Entry> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e =it.next();
            if((int)e.getKey()>max){
                max = (int)e.getKey();
                count = (int)e.getValue();
            }
        }
        return count;
    }
}
