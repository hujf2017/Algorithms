package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/20 9:19
 * @Description TODO
 */
public class lekthGrammar {
    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if (k == 2) {
            return 1;
        }

        int  left = kthGrammar( n, (k+1)/2);
        if(k%2==0){
            left = left == 0 ? 1 : 0;
        }else {
            left = left == 0 ? 0 : 1;
        }

        return left;

    }

    @Test
    public void t() {
        System.out.println(kthGrammar(5, 9));
    }
}
