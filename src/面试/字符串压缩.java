package 面试;

/**
 * @author Hujf
 * @title: 字符串压缩
 * @date 2020/10/10 0010上午 10:01
 * @description: TODO
 */
public class 字符串压缩 {
    public String compressString(String S) {
        int last = 0;
        char a[] = S.toCharArray();
        char lastc = a[0];
        String s = "";
        for (int i = 1; i < a.length; i++) {
            if (a[i] == lastc) {
                last++;
            } else {
                String xs = String.valueOf(a[i]);
                s = s + xs + last;
                last = 0;
                lastc = a[i];
            }
        }
        if (S.length()<s.length()){
            return s;
        }else{
            return S;
        }
    }


    public String compressString2(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        int last = 1;
        StringBuffer ans = new StringBuffer();
        char lastc = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == lastc) {
                last++;
            } else {
                ans.append(lastc);
                ans.append(last);
                lastc = S.charAt(i);
                last = 1;
            }
        }
        ans.append(lastc);
        ans.append(last);
        if (S.length()<=ans.length()){
            return S;
        }else{
            return ans.toString();
        }
    }
}
