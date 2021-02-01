package leecode;

/**
 * @author Hujf
 * @title: le1460
 * @date 2021/1/29 0029上午 9:03
 * @description: TODO
 */
public class le1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        int a=0,b=0,c=0,d=0;
        for(int i=0;i<target.length;i++){
            a^=target[i];
            b^=arr[i];
            c+=target[i];
            d+=arr[i];
        }
        return (a==b)&&(c==d);
    }
}
