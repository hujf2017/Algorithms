package leecode;

/**
 * @author Hujf
 * @title: le922
 * @date 2020/11/12 0012下午 12:26
 * @description: TODO
 */
public class le922 {
    public int[] sortArrayByParityII(int[] A) {
        int ji = 1;int ou =0;
        int B[]= new int[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                B[ou]=A[i];
                ou+=2;
            }else{
                B[ji]=A[i];
                ji+=2;
            }
        }
        return B;
    }
}
