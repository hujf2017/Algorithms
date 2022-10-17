package leecode;

/**
 * @Author hujf
 * @Date 2022/10/14 10:23
 * @Description 前缀树 字典树
 */
public class WordDictionary {


    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) {
                p.children[i] = new TrieNode();
            }
            p = p.children[i];
        }
        p.end = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode root, String key, int index) {
        if (index >= key.length()) {
            return root.end;
        }
        if (root == null) {
            return false;
        }
        int i = key.charAt(index) - 'a';
        if (key.charAt(index) == '.') {
            //因为可以替换所有  所有直接遍历所有的
            for (int j = 0; j < 26; j++) {
                //只要有一条路 则ok
                if (search(root.children[j], key, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return search(root.children[i], key, index + 1);
        }
    }
}
