package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/6/22 9:44
 * @Description TODO
 */
public class le22 {
    List<String> a = new ArrayList();
    public List<String> generateParenthesis(int n) {
        StringBuilder sbd  = new StringBuilder("(");
        dfs(n-1,n,sbd);
        return a;
    }

    private void dfs(int left,int right, StringBuilder sbd) {
        if(left ==0&&right==0){
            a.add(sbd.toString());
            return ;
        }
        if(left>0){
            dfs(left-1,right,sbd.append("("));
            sbd.deleteCharAt(sbd.length()-1);
        }
        if(right>0&&right>left){
            dfs(left,right-1,sbd.append(")"));
            sbd.deleteCharAt(sbd.length()-1);
        }
    }
    @Test
    public void te(){
        generateParenthesis(1);
    }
}
