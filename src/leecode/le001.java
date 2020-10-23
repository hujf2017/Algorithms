package leecode;

/**
 * @author Hujf
 * @title: le001
 * @date 2020/9/5 0005下午 4:13
 * @description: TODO
 */
public class le001 {
    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int a[] = twoSum(nums, target);
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        int numsa[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    numsa[0] = i;
                    numsa[1] = j;
                    return numsa;
                }
            }
        }
        return null;
    }
}
