package 比赛;

/**
 * @author Hujf
 * @title: le5654
 * @date 2021/1/31 0031上午 11:08
 * @description: TODO
 */
public class le5654 {
    public int countBalls(int lowLimit, int highLimit) {
        int []a = new int[50];
        for(int i=lowLimit;i<=highLimit;i++){
            char []s = String.valueOf(i).toCharArray();
            int num =0;
            for(char s1:s){
                num += s1-'0';
            }
            a[num]+=1;
        }

        int max =0;
        for(int k:a){
            if(k>max){
                max = k;
            }
        }
        return max;
    }
}
