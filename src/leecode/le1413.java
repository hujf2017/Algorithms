package leecode;

/**
 * @Author hujf
 * @Date 2022/8/9 9:21
 * @Description TODO
 */
public class le1413 {
    int min = 1;
    public int minStartValue(int[] nums) {
        int count =0;
        for(int i:nums){
            count = count+i;
            min = Math.min(count,min);
        }

        return min>=1?0:1-min;
    }
}
