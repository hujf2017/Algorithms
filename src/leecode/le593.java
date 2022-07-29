package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/7/29 9:43
 * @Description TODO
 */
public class le593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> a = new ArrayList();
        a.add(p1);
        a.add(p2);
        a.add(p3);
        a.add(p4);
        Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        if (a.get(0)[0] == a.get(3)[0]) {
            return false;
        }
        return calc(a.get(0), a.get(1), a.get(2), a.get(3));
    }

    private boolean calc(int[] p1, int[] p2, int[] p3, int[] p4) {
        int num1 = (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
        int num2 = (int) (Math.pow(p1[0] - p3[0], 2) + Math.pow(p1[1] - p3[1], 2));
        int num3 = (int) (Math.pow(p4[0] - p2[0], 2) + Math.pow(p4[1] - p2[1], 2));
        int num4 = (int) (Math.pow(p4[0] - p2[0], 2) + Math.pow(p4[1] - p2[1], 2));
        long point1x = p1[1] - p2[1];
        long point1y = p1[0] - p2[0];

        long point2x = p1[1] - p3[1];
        long point2y = p1[0] - p3[0];

        long numy = point2y * point1y;
        long nunx = point2x * point1x;

        return (num1 == num2 && num1 == num3 && num1 == num4 && nunx == -numy);
    }

    @Test
    public void t() {
        System.out.println(validSquare(new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}));
    }
}
