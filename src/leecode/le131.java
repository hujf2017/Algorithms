package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hujf
 * @title: le131
 * @date 2021/3/8 0008下午 2:18
 * @description: TODO
 */
public class le131 {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;
    int min = Integer.MAX_VALUE;
    public List <List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                //判断ij 是不是回文
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        //得到一个二维数组 f可以判断是不是回文ij
        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int i) {
        if(i==n){
            min = Math.min(min,ans.size());
            ret.add(new ArrayList<String>(ans));
            return ;
        }

        for(int j=i;j<n;j++){
            if(f[i][j]){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                //除掉上一个重复的
                ans.remove(ans.size()-1);
            }
        }
    }

    @Test
    public void t(){
        System.out.println(partition("aab"));
    }
}
