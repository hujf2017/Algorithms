package leecode;

/**
 * @author Hujf
 * @title: le832
 * @date 2020/10/2 0002下午 2:07
 * @description: TODO
 */
public class le832 {
    public int[][] flipAndInvertImage(int[][] A) {
        //多少行
        for(int i=0;i<A.length;i++){
            int copy[] = A[i].clone();
            int len = copy.length;
            for(int j = 0;j<len;j++){
                A[i][j] = Math.abs(copy[len-1-j]-1);
            }
        }
String s = "";
        StringBuilder sd =  new StringBuilder(s);

        if (s.equals(sd.reverse().toString())) {

        }
        return A;
    }
}
