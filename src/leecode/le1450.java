package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author Hujf
 * @title: le1450
 * @date 2021/1/22 0022上午 10:00
 * @description: TODO
 */
public class le1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for(int i=0;i<startTime.length;i++){
            int s = startTime[i];
            int e = endTime[i];
            if(queryTime>=s&&queryTime<=e){
                count++;
            }
        }
        return count;
    }

    //差分数组 start  在那个位置+1  end(end 也算在工作)  则是在那个位置的后一位 减一
    public int busyStudent2(int[] startTime, int[] endTime, int queryTime) {

        //所以要找到最大的endtime

        int first = Arrays.stream(endTime).max().getAsInt();
        if (queryTime > first) {
            return 0;
        }
        int []cnt = new int[first+2];
        for(int i=0;i<startTime.length;i++){
            cnt[startTime[i]]++;
            cnt[endTime[i]+1]--;
        }

        int count = 0;
        for(int i=0;i<=queryTime;i++){
            count+=cnt[i];
        }

        return count;
    }


    @Test
    public void t(){
        busyStudent2(new int[]{1,1,1,1},new int[]{1,3,2,4},7);
    }
}
