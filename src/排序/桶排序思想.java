package 排序;

/**
 * @Author hujf
 * @Date 2022/6/15 17:17
 * @Description TODO
 */
public class 桶排序思想 {
    static int nu[] = new int[]{321, 4, 43, 4, 34, 54, 5, 456, 6, 5, 65, 6, 67, 87, 8, 78, 7, 87, 8, 78, 78};

    public static void main(String[] args) {
        int k = 10;


        //一切的开始

        int[] num = new int[10000000];

        for (int i : nu) {
            num[i]++;
        }
        for (int i=0;i<num.length ; i++) {
            k = k - num[i];
            if (k < 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
