package leecode;

/**
 * @Author hujf
 * @Date 2022/11/1 9:41
 * @Description TODO
 */
public class le1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return join(word1).equals(join(word2));
    }

    private String join(String[] word) {
        StringBuilder sbd = new StringBuilder();
        for(String s:word){
            sbd.append(s);
        }
        return sbd.toString();
    }
}
