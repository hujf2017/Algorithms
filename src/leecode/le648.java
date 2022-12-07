package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/11/9 14:26
 * @Description TODO
 */
public class le648 {
    TrieNode nodes = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        BuildTree(nodes, dictionary);

        String[] s = sentence.split(" ");
        int count = 0;
        for (String sx : s) {
            //对每个单词 找到最短的词跟
            String x = searchMinTail(sx,nodes) ;
            if(x!=null){
                s[count] = x;
            }
            count++;
        }
        return  String.join(" ", s);
    }

    private String searchMinTail(String sx, TrieNode nodes) {
        for(int i=0;i<sx.length();i++){
            int num = sx.charAt(i) -'a';
            if(nodes.children[num]!=null){
                if(nodes.children[num].end){
                    return sx.substring(0,i+1);
                }
                nodes = nodes.children[num];
            }else {
                return null;
            }
        }
        return null;
    }

    private void BuildTree(TrieNode nodes, List<String> dictionary) {
        for (String x : dictionary) {
            insert(x, nodes);
        }
    }

    private void insert(String x, TrieNode nodes) {
        for (int i = 0; i < x.length(); i++) {
            int index = x.charAt(i) - 'a';
            if (nodes.children[index] == null) {
                nodes.children[index] = new TrieNode();
            }
            nodes = nodes.children[index];
        }
        nodes.end = true;
    }

    //dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
    @Test
    public void t() {
        System.out.println(replaceWords(Arrays.asList(new String[]{"cat", "bat", "rat"}), "the cattle was rattled by the battery"));
    }
}
