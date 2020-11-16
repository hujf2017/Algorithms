package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le406
 * @date 2020/11/16 0016上午 11:24
 * @description: 组合数学
 */
public class le406升高重建队列 {
    public int[][] reconstructQueue1(int[][] people) {

        int len = people.length;
        if(len==0){
            return people;
        }
        int mid[] =new int[len];
        //二维数组的排序 如果第一个相同 用第二个 负不交换位置 故前面减后面是递增
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int[][] aim =new int[len][2];
        boolean havedouZero =false;
        if(people[0][0]==0&&people[0][1]==0){
            havedouZero=true;
        }
        for(int i=0;i<len;i++){
            //得到中介数
            int midnum = people[i][1];
            int height = people[i][0];
            int count =0;
            if(havedouZero==true){
                midnum++;
            }
            //利用中介数数组进行插入一个新的二维数组。从最小的开始
            //每次找midnum个空位
            while(midnum>0){
                if((aim[count][0]==0&&aim[count][1]==0)||aim[count][0]>=height){
                    midnum--;
                }
                count++;
            }
            while(!(aim[count][0]==0&&aim[count][1]==0)){
                count++;
            }
            aim[count] = people[i];
        }
       return aim;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p: people){
            list.add(p[1], p);
        }
        return list.toArray(new int[0][2]);
    }

    @Test
    public void t(){
        int k[][]= new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(k);
    }

}
