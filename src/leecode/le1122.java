package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le1122
 * @date 2020/9/15 0015上午 10:38
 * @description: TODO
 */
public class le1122 {

    @Test
    public void relativeSortArray() {
        int[] arr1 = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = new int[]{2,42,38,0,43,21};
        int a[] = new int[arr1.length];
        int ax [] = new int[1001];
        for(int num1 : arr1){
            ax[num1]+=1;
        }
        int m=0;
        int j = m;
        for(int i=0;i<arr2.length;i++){
            int k =arr2[i];
            int num = ax[k];
            ax[k]= 0;

            for(j=m;j<num+m;j++){
                a[j] =k;
            }
            m=j;
        }
        for(int i=0;i<ax.length;i++){
            if(ax[i]!=0){
                for(int k=0;k<ax[i];k++) {
                    a[j] = i;
                    j++;
                }
            }
        }
        System.out.println(a);
    }



    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        //1.先用map 存一下 arr2
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1){
            //得到需要排序的东西
            list.add(num);
        }
        for(int i = 0; i < arr2.length; i++) {
            //得到每个数的顺序
            map.put(arr2[i], i);
        }

        Collections.sort(list,(x,y)->{
            //如果存在，
            if(map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            //不存在则返回字典序
            return x - y;
        });

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
