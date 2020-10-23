package 比赛;

/**
 * @author Hujf
 * @title: 比赛2
 * @date 2020/9/5 0005下午 10:50
 * @description: TODO
 */
public class 比赛2 {
    public static void main(String args[]){
        // int a[][] = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        String s = "0000";
        System.out.println(numWays(s));
    }

    public static int numWays(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-48==1){
                count++;
            }
        }
        if(count%3!=0){
            return 0;
        }
        if(count==0){
            long aa = (long) ((s.length()-1)%(Math.pow(10,9)+7));
            long bb = (long) ((s.length()-2)%(Math.pow(10,9)+7));
            return (int) ((int) aa*bb%(Math.pow(10,9)+7))/2;
        }

        int m = count/3;
        int  n =0;
        long first=0;
        long second=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-48==1){
                n++;
            }
            if(n==m){
                first++;
            }
            if(n==2*m){
                second++;
            }
        }

        return (int) (first%(Math.pow(10,9)+7)*second%(Math.pow(10,9)+7));

    }
}
