package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/2 9:57
 * @Description TODO
 */
public class le684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] node = new int[11];
        int[] aim = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int[] k = edges[i];
            int num1 = find(k[0],node);
            int num2 = find(k[1],node);

            if (num1 == num2) {
                //多余了
                aim[0] = k[0];
                aim[1] = k[1];
            } else {
                node[num1] = num2;
            }

        }
        return aim;
    }

    private int find(int i,int[] node) {
        if(node[i]==i||node[i]==0){
            node[i] = i;
            return i;
        }else {
            return  find(node[i],node);
        }
    }

    @Test
    public void t(){
        findRedundantConnection(new int[][]{{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}}
        );
    }
}
