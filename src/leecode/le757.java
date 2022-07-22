package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/7/22 9:31
 * @Description TODO
 */
public class le757 {


    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
        int m = 2;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<Integer>[] temp = new List[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new ArrayList<Integer>();
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = temp[i].size(); k < m; j++, k++) {
                System.out.println(j);
                res++;
                help(intervals, temp, i - 1, j);
            }
        }

        return res;

    }


    public void help(int[][] intervals, List<Integer>[] temp, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) {
                break;
            }
            temp[i].add(num);
        }
    }


    @Test
    public void t() {
        int[][] a = new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}};
        intersectionSizeTwo(a);
    }

}


