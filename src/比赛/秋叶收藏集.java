package 比赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: 秋叶收藏集
 * @date 2020/9/12 0012下午 3:57
 * @description: TODO
 */
public class 秋叶收藏集 {
    public static void main(String args[]) {
        String s = "yyrryyyryyr";
        System.out.println(minimumOperations(s));
    }

    public static int minimumOperations(String leaves) {
        int n = leaves.length();
        //调整操作次数 以及第 i 片叶子处于状态 0,1,2 时的最小操作次数
        int[][] f = new int[n][3];
        //第一片叶子 处于状态0的操作次数
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        //第一片叶子 处于状态1,2的操作次数  第二篇叶子处于状态2的次数 都是不可能的
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            //第ipian叶子处于状态0的操作次数  = 第i-1片叶子处于状态0的次数+ 是否需要修改
            f[i][0] = f[i - 1][0] + isYellow;
            //第ipian叶子处于状态1的操作次数  = 第i-1片叶子处于状态1和0的最小值   + 是否需要修改
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
            if (i >= 2) {
                //第i片叶子处于状态2的最小操作 = 第i-1片叶子处于状态2和1的最小值
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
            }
        }
        return f[n - 1][2];
    }
}
