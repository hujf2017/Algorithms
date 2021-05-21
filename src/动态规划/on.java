package 动态规划;

/**
 * @author Hujf
 * @title: on
 * @date 2021-05-19 11:21
 * @description: TODO
 */
public class on {
    public static void main(String[] args) {
        int n=10;
        dfsos(n);
    }

    public static void dfsos(int n){
        for(int i=0;i<n;i++){
            dfsos(n-1);
        }
    }
}

