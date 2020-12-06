package leecode;

/**
 * @author Hujf
 * @title: le34
 * @date 2020/12/1 0001下午 2:04
 * @description: TODO
 */
public class le34 {
    public int[] searchRange(int[] nums, int target) {
        int []a=new int[2];
        int count =-1;
        int getfrist=-1;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                if(getfrist==-1){
                    getfrist = i;
                }

                count++;
            }else{
                if(getfrist!=-1){
                    break;
                }
            }
        }

        if(getfrist==-1){
             a[0] = -1;
            a[1]=-1;
        }else{
            a[0] = getfrist;
            a[1] = a[0]+count;
        }
        return a;
    }
}
