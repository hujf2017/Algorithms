package 比赛;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/8/1 15:22
 * @Description tanxin  从 1开始  每次取比 前一个大最少的
 */
public class le2358 {

    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int num = 0;
        int index = 0;
        while (index < grades.length) {
            num++;
            index += num;
        }
        if(index>grades.length){
            num--;
        }
        return num;
    }

    @Test
    public void t(){
        int []num = new int[]{10,6,12,7,3,5};
        maximumGroups(num);
    }
}
