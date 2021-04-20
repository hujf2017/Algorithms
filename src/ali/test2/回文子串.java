package ali.test2;

/**
 * @author Hujf
 * @title: 回文子串
 * @date 2021/4/1317:40
 * @description: TODO
 */
public class 回文子串 {

    //方法一：中心拓展  aa  3个
    
    public int countSubstring (String s ){
        int n=s.length(),ans=0;

        for(int i=0;i<2*n-1;i++){
            int l=i/2,r=i/2+i%2;

            while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }

}
