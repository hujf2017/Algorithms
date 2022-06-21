package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/6/21 11:24
 * @Description TODO
 */
public class le2311 {
    public static void main(String[] args) {
        //
    }


    //高于k的位数1 全部去掉
    public int longestSubsequence(String s, int k) {

        int num =0;
        StringBuilder snum = new StringBuilder() ;
        while(k>0){
            int x =k%2;
            k=k>>1;
            num++;
            snum.append(x);
        }
        if(num>s.length()){
            return s.length();
        }

        char[] chars = s.toCharArray();
        int xx =0;
        for(int i=0;i<chars.length-num;i++){
            if(chars[i]=='0'){
                xx++;
            }
        }
        String substring = s.substring(chars.length - num );


        if(substring.compareTo(snum.reverse().toString())>0){
            return xx+num-1;
        }else{
            return xx+num;
        }
    }

    @Test
    public  void main() {
        longestSubsequence("0",
                583196182
        );
    }
}
