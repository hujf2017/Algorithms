package leecode;

/**
 * @author Hujf
 * @title: le771
 * @date 2020/10/2 0002下午 2:04
 * @description: TODO
 */
public class le771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i=0;i<S.length();i++){
            for(int j=0;j<J.length();j++){
                if(S.charAt(i)==J.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
}
