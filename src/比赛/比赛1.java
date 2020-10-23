package 比赛;

/**
 * @author Hujf
 * @title: 比赛1
 * @date 2020/9/5 0005下午 10:38
 * @description: TODO
 */
public class 比赛1 {
    public static void main(String args[]){
       // int a[][] = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int a[][] = {{1}};
        System.out.println(calc(a));
    }

    public  static int calc(int [][] mat){
        int sum=0 ;
        int len = mat.length;
        for(int i=0;i<len;i++){
            sum =sum+ mat[i][i]+mat[i][len-i-1];
        }
        if(len%2==1){
            return sum-mat[len/2][len/2];
        }
        return sum;
    }
}
