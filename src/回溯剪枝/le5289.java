package 回溯剪枝;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/6/13 15:09
 * @Description TODO
 */
public class le5289 {
    int[] cookies = null;
    int n = 0;
    int k = 0;
    int res = Integer.MAX_VALUE;


    public int distributeCookies(int []cookies,int k){
        Arrays.sort(cookies);
        this.cookies = cookies;
        this.n = cookies.length;
        this.k = k;
        dfs(new int[k], n - 1);
        return res;
    }

    //所有的东西
    void dfs(int[] bkt, int index) {
        if(index<0){
            int max = 0;
            for(int b:bkt){
                max = Math.max(b,max);
            }
            res = Math.min(max,res);
            return;
        }
       for(int i=0;i<k;i++){
           if (index == n - 1 && i > 0) return;
           bkt[i]+=cookies[index];
           dfs(bkt,index-1);
           bkt[i]-=cookies[index];
       }
    }

    @Test
    public void tr(){
        distributeCookies(new int[]{8,15,10,20,8},3);
    }
}
