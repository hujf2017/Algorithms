package leecode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hujf
 * @title: le1337
 * @date 2021/1/23 0023上午 9:37
 * @description: TODO
 */
public class le1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] tmp = new int[mat.length][2];
        for(int i = 0; i < mat.length; i++){
            //第一个为宗旨存放的书索引
            tmp[i][0] = i;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    //第二个位置存放战斗力
                    tmp[i][1] += 1;
                }
            }
        }

        Arrays.sort(tmp, (o1, o2) -> {
            if(o1[1]==o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        int[] res = new int[k];
        for(int i =0; i < k; i++) {
            res[i] = tmp[i][0];
        }
        return res;

    }
}
