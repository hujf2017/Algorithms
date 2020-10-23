package 比赛;

/**
 * @author Hujf
 * @title: le5508
 * @date 2020/9/6 0006上午 10:58
 * @description: TODO
 */
public class le5508 {
    public static void main(String args[]){
        int a[] = {100000};
        int b[] ={100000,100000};
        System.out.println(numTriplets(a,b));
    }

    public static  int numTriplets(int[] nums1, int[] nums2) {
        int a[] =new int[100001];
        int b[] =new int[100001];
        for(int i=0;i<nums1.length;i++){
            a[nums1[i]] = a[nums1[i]]+1;
        }
        for(int i=0;i<nums2.length;i++){
            b[nums2[i]] = b[nums2[i]]+1;
        }
        int count = 0;
        int count2 = 0;

        for(int i=0;i<nums2.length;i++){
            for(int j=i+1;j<nums2.length;j++){
                int x = nums2[i]*nums2[j];
                int y = (int) Math.sqrt(x);
                if(y*y==x&&a[y]!=0&&x/nums2[i] ==nums2[j]){
                    count = count+a[y];
                }
                if(nums2[i] ==100000 && nums2[j]==100000 &&a[100000]!=0){
                    count = count+a[100000];
                }
            }
        }

        for(int i=0;i<nums1.length;i++){
            for(int j=i+1;j<nums1.length;j++){
                int x = nums1[i]*nums1[j];
                int y = (int) Math.sqrt(x);
                if(y*y==x&&b[y]!=0&&x/nums1[i] ==nums1[j] ){
                    count2 =count2+b[y];
                }
                if(nums1[i] ==100000 && nums1[j]==100000 &&b[100000]!=0){
                    count2 = count2+b[100000];
                }
            }
        }
        return count+count2;
    }
}
