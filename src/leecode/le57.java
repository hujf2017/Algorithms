package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le57
 * @date 2020/11/4 0004上午 10:58
 * @description: TODO
 */
public class le57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{start, end});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < start) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{start, end});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
