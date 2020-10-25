package 比赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hujf
 * @title: le5547等差子数组
 * @date 2020/10/25 0025下午 5:24
 * @description: TODO
 */
public class le5547等差子数组 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int num = l.length;
        List<Boolean> sss= new ArrayList<Boolean>();
        for(int i=0;i<num;i++){
            int start = l[i];
            int end = r[i];
            int ax[] = new int[end-start+1];
            for(int j=start;j<=end;j++){
                ax[j-start]=nums[j];
            }
            Arrays.sort(ax);
            boolean isha = true;
            for(int j=2;j<ax.length;j++){
                if(ax[j]-ax[j-1]!=ax[j-1]-ax[j-2]){
                    sss.add(false);
                    isha=false;
                    break;
                }
            }
            if(isha==true){
                sss.add(true);
            }
        }
        return  sss;
    }
}
