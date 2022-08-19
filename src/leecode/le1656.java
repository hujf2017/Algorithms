package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/8/16 9:20
 * @Description TODO
 */
public class le1656 {

    String[] a;
    int ptr = 1;
    public le1656(int n) {
        a = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        a[idKey] = value;
        List<String> s = new ArrayList();
        if (ptr == idKey) {
            while (ptr < a.length && a[ptr] != null && !a[ptr].equals("")) {
                s.add(a[ptr]);
                ptr++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        le1656 os = new le1656(5);
        os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
        os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
        os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }
}
