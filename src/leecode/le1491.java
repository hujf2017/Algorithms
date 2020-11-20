package leecode;

/**
 * @author Hujf
 * @title: le1491
 * @date 2020/11/20 0020上午 9:49
 * @description: TODO
 */
public class le1491 {
    public double average(int[] salary) {
        double max =Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        int len = salary.length;
        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum += salary[i];
            if (max < salary[i]) {
                max = salary[i];
            }

            if (min > salary[i]) {
                min = salary[i];
            }
        }
        sum = sum - max - min;
        return sum/(len-2);
    }

}
