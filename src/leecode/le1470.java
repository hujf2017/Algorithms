package leecode;

/**
 * @Author hujf
 * @Date 2022/8/29 16:09
 * @Description TODO
 */
public class le1470 {
    public int[] shuffle(int[] nums, int n) {
//        for(int i=1;i<n;i++){
//            int count =0;
//            while(count<2) {
//                int temp = nums[i+count];
//                nums[i+count] = nums[i + n];
//                nums[i + n+count] = temp;
//                count++;
//            }
//        }
//
//        return nums;

        int num2[] = new int[2*n];
        for(int i=0;i<n;i++){
            num2[i*2] = nums[i];
        }
        for(int i=0;i<n;i++){
            num2[i*2+1]= nums[i+n];
        }
        return num2;
    }
}
