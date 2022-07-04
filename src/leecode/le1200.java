package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/7/4 8:53
 * @Description TODO
 */
public class le1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int last = arr[0];
        List<List<Integer>> x = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last < min) {
                List<Integer> a = new ArrayList();
                a.add(last);
                a.add(arr[i]);
                x.clear();
                x.add(a);
                min = arr[i] - last;
            } else if (arr[i] - last == min) {
                List<Integer> a = new ArrayList();
                a.add(last);
                a.add(arr[i]);
                x.add(a);
            } else {
            }

            last = arr[i];
        }
        return x;
    }
    @Test
    public void t(){
        minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27});
    }
}
