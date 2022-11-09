package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/2 9:35
 * @Description TODO
 */
public class le1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] aim = new int[51][51];
        for (int i = 0; i < towers.length; i++) {
            int[] point = towers[i];
            calc(aim, point, radius);
        }
        int max = 0;
        int[] ai = new int[2];
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                if (aim[i][j] > max) {
                    ai[0] = i;
                    ai[1] = j;
                    max = aim[i][j];
                }
            }
        }
        return ai;
    }

    private void calc(int[][] aim, int[] point, int radius) {
        int xStart = point[0] - radius >= 0 ? point[0] - radius : 0;
        int xend = point[0] + radius <= 50 ? point[0] + radius : 50;

        int yStart = point[1] - radius >= 0 ? point[1] - radius : 0;
        int yend = point[1] + radius <= 50 ? point[1] + radius : 50;

        for (int i = xStart; i <= xend; i++) {
            for (int j = yStart; j <= yend; j++) {
                double sqrt = Math.sqrt(Math.pow(i - point[0], 2) + Math.pow(j - point[1], 2));
                if ( sqrt<= radius) {
                    aim[i][j]+=(int)(point[2]/(sqrt+1));
                }
            }
        }
    }

    @Test
    public void t(){
        bestCoordinate(new int[][]{{1,2,5},{2,1,7},{3,1,9}},2);
    }
}
