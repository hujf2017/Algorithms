package leecode;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/6/13 9:20
 * @Description TODO
 */
public class le1051 {
    public static int heightChecker(int[] heights) {
        int[]height = heights.clone();
        Arrays.sort(heights);
        int count =0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=height[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        heightChecker(new int[]{1,1,4,2,1,3});
    }
}
