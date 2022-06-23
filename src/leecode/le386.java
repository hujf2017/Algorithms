package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/6/23 9:24
 * @Description TODO
 */
public class le386 {
    List<Integer> ret = new ArrayList<Integer>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            if(i<=n) {
                ret.add(i);
                dfs(i, n);
            }
        }
        return ret;
    }

    private void dfs(int num,int aim) {
        for (int i = 0; i < 10; i++) {
            if(num*10+i<=aim){
                ret.add(num*10+i);
                dfs(num*10+i,aim);
            }
        }
    }

    @Test
    public void t(){
        lexicalOrder(2);
    }
}
