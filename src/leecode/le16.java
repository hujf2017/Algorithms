package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/3/18 17:47
 * @Description TODO
 */
public class le16 {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int aim = Integer.MAX_VALUE;
        int[] numx = new int[2001];
        for (int i = 0; i < nums.length; i++) {
            numx[nums[i] + 1000] = numx[nums[i] + 1000] + 1;
        }

        int maxx = -10000;
        for (int i = 2000; i >= 0; i--) {
            if (numx[i] != 0) {
                maxx = i - 1000;
                break;
            }
        }
        int minx = 100000;
        for (int i = 0; i < 2001; i++) {
            if (numx[i] != 0) {
                minx = i - 1000;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = target - nums[i] - nums[j];
                numx[nums[i] + 1000]--;
                numx[nums[j] + 1000]--;
                int close;
                if (x > 1001&&numx[maxx+ 1000]>0) {
                    close = maxx;
                } else if (x < -1001&&numx[minx+ 1000]>0) {
                    close = minx;
                } else {
                    close = findclose(numx, x + 1000);
                }
                if (min > Math.abs(x - close)) {
                    min = Math.abs(x - close);
                    aim = nums[i] + nums[j] + close;
                }
                numx[nums[i] + 1000]++;
                numx[nums[j] + 1000]++;
            }
        }
        return aim;
    }

    private int findclose(int[] numx, int index) {
        int left = index;
        int right = index;
        while (true) {

            if (left < 2001 && left > 0 && numx[left] > 0) {
                return left - 1000;
            }

            if (right < 2001 && right > 0 && numx[right] > 0) {
                return right - 1000;
            }
            left--;
            right++;
        }
    }

    @Test
    public void t() {
        threeSumClosest(new int[]{-641,-512, -776
        }, -7713);
    }
}
