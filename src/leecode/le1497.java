package leecode;

/**
 * @author Hujf
 * @title: le1497
 * @date 2020/9/28 0028上午 10:12
 * @description: TODO
 */
public class le1497 {
    public boolean canArrange(int[] arr, int k) {
        int s[] = new int[k+1];
        for(int i=0;i<arr.length;i++){
            int m = arr[i]%k;
            s[m]+=1;
        }
        int sd = (int) Math.pow(10,2);
        int sdx[] = new int[1000];
        boolean isOk = true;
        for(int i=1;i<(k+1)/2;i++ ){
            int a = s[i];
            if(s[k-i]!=a){
                isOk = false;
                break;
            }
        }
        return isOk;
    }
}
