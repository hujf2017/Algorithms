package 面试.阿里;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Hujf
 * @title: 最小k个数
 * @date 2021/4/1215:01
 * @description: TODO
 */
public class 最小k个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> a = new ArrayList();
        for(int i=0;i<k;i++){
            a.add(input[i]);

        }
        return a;
    }
}
