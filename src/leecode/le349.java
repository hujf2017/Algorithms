package leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hujf
 * @title: le349
 * @date 2020/11/2 0002下午 6:17
 * @description: TODO
 */
public class le349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ax = new HashSet<>();
        Set set = new HashSet();
        for(int i :nums1){
            set.add(i);
        }
        for(int i :nums2){
            if(set.contains(i)){
                ax.add(i);
            }
        }
        int am[] = new int[ax.size()];
        int k=0;
        for(int i:ax){
            am[k] = i;
            k++;
        }// a.stream().mapToInt(Integer::a).toArray();
        return am;
    }
}
