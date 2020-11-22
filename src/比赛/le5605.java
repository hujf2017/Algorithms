package 比赛;

/**
 * @author Hujf
 * @title: le5605
 * @date 2020/11/22 0022上午 10:30
 * @description: TODO
 */
public class le5605 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sbf1 = new StringBuffer();
        StringBuffer sbf2 = new StringBuffer();
        for(int i=0;i<word1.length;i++){
            sbf1.append(word1[i]);
        }
        for(int i=0;i<word2.length;i++){
            sbf2.append(word2[i]);
        }
        return sbf1.toString().equals(sbf2.toString());

    }
}
