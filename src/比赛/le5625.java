package 比赛;

/**
 * @author Hujf
 * @title: le5625
 * @date 2020/12/13 0013上午 10:31
 * @description: TODO
 */
public class le5625 {

    public int minPartitions(String n) {
        int max =0;
        char a[]  = n.toCharArray();
        for(int i=0;i<a.length;i++){
            max = Math.max(max, (int)a[i]-48);
        }
        return max;
    }
}
