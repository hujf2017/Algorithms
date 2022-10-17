package leecode;


import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/14 10:03
 * @Description 前缀树」又叫「字典树」或「单词查找树」
 */
public class le2416 {
    private TrieNode root;

    public le2416() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode p = root;
        for(int i=0;i<word.length();i++){
            int num = word.charAt(i)-'a';
            if(p.children[num]==null){
                p.children[num] = new TrieNode();
            }
            p = p.children[num];
            p.val ++;
        }
    }


    public int[] sumPrefixScores(String[] words) {
        //1.计算每个字符串的前缀
        for (String s : words) {
            insert(s);
        }
        int []num = new int[words.length];
        int count =0;
        for(String s :words){
            num[count++] = getPathSum(s);
        }
        return num;
    }

    private int getPathSum(String s) {
        TrieNode p = root;
        int sum =0;
        for(int i=0;i<s.length();i++){
            if(p.children[s.charAt(i)-'a']!=null){
                sum+=p.children[s.charAt(i)-'a'].val;
            }
            p = p.children[s.charAt(i)-'a'];
        }
        return sum;
    }


    @Test
    public void t(){
        sumPrefixScores(new String[]{"abc","ab","bc","b"});
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int val;
    boolean end;
}
