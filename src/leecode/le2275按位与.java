package leecode;

/**
 * @Author hujf
 * @Date 2022/6/2 10:16
 * @Description 全部转化为以为数组  然后看每列1最多的 就是最大的
 */
public class le2275按位与 {

    public static int last(int[] nums) {
        int[] s = new int[32];
        for (int num : nums) {
            int local = num;
            int index = 0;
            while (local > 0) {
                int nu = local % 2;
                local = local / 2;
                if (nu == 1) {
                    s[index]++;
                }
                index++;
            }
        }
        int max = 0;
        for(int i:s){
            max = Math.max(max,i);
        }
        return max;
    }

    public static void main(String[] args) {
        last(new int[]{16, 17, 71, 62, 12, 24, 14});
    }
}
