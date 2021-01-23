package leecode;

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
}
