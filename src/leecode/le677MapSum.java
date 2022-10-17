package leecode;

/**
 * @Author hujf
 * @Date 2022/10/14 10:40
 * @Description TODO
 */
public class le677MapSum {

    private TrieNode root;

    public le677MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode p = root;
        char[] chars = key.toCharArray();
        for (char c : chars) {
            int num = c - 'a';
            if (p.children[num] == null) {
                p.children[num] = new TrieNode();
            }
            p = p.children[num];
        }
        p.val = val;
    }

    public int sum(String prefix) {
        TrieNode p = getPrefixNode(prefix);
        if (p == null) {
            return 0;
        }

        //递归找这个树的值
        return dfs(p);
    }

    private int dfs(TrieNode p) {
        if (p == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += dfs(p.children[i]);
        }
        return sum+p.val;
    }

    private TrieNode getPrefixNode(String prefix) {
        TrieNode p = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            int num = c - 'a';
            if (p.children[num] == null) {
                return null;
            }
            p = p.children[num];
        }
        return p;
    }

}


