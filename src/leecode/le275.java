package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/17 10:24
 * @Description TODO
 */
public class le275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int max = citations[n-1];
        int count =0;
        int h = 0;
        for(int index =n-1;index>=0;index--){
            count+=1;
            max = Math.min(citations[index],max);
            if(max >=count){
                h = Math.max(h,count);
            }
        }
        return h;
    }

    @Test
    public void t(){
        hIndex(new int[]{2,3});
    }

}
