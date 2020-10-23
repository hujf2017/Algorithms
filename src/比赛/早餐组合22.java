package 比赛;

import java.util.*;

/**
 * @author Hujf
 * @title: 早餐组合22
 * @date 2020/9/12 0012下午 3:44
 * @description: TODO
 */
public class 早餐组合22 {
    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        long count = 0;
        for(int i=0;i<staple.length;i++){
            for(int j=0;j<drinks.length;j++){
                if(staple[i]+drinks[j]<=x){
                    count++;
                }
            }
        }
        return (int)count%1000000007;
    }


    public static void main(String args[]) {
        int []staple = {10,20,5};
        int drinks [] ={5,5,2};
        System.out.println(breakfastNumber(staple,drinks,9));
    }

    public static int breakfastNumber3(int[] staple, int[] drinks, int x) {
        int count = 0;
        int []a= new int[100001];
        for(int i=0;i<staple.length;i++){
            a[staple[i]]+=1;
        }

        for(int i=0;i<drinks.length;i++){
            int k = x - drinks[i];
            for(int j=k;j>=0;j--){
                count +=a[j];
            }
        }
        return count%1000000007;
    }


    public static int breakfastNumber4(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long  sum = 0;
        int k =drinks.length-1;
        for(int i=0;i<staple.length;i++){
            for(int j=k;j>=0;j--){
                if(staple[i]+drinks[j]>x){
                    continue;
                }else{
                    sum+=j+1;
                    k=j;
                    break;
                }
            }
        }
        int mod = (int)1e9 + 7;
        return (int)(sum%mod);
    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long sum = 0;
        int k =drinks.length-1;
        for(int i=0;i<staple.length;i++){
            while(k>=0&&staple[i]+drinks[k]>x){
                k--;
            }
            sum +=k+1;
        }
        int mod = (int)1e9 + 7;
        return (int)(sum%mod);
    }
}
