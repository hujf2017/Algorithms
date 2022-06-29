package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hujf
 * @Date 2022/6/29 14:47
 * @Description TODO
 */
public class le535 {

    Map<String,String> map = new HashMap<>();

    //加密
    public String encode(String longUrl) {
        StringBuilder sbd = new StringBuilder();
        int count = 0;
        int i = longUrl.indexOf("//");
        String substring = longUrl.substring(0, i + 2);
        String substring1 = longUrl.substring(i + 2);
        int index;
        if((index=substring1.indexOf("/"))!=-1){
            sbd.append(substring1.substring(0,index)+"/");
        }else{
            return longUrl;
        }
        while (substring1.indexOf("/") != -1) {
            int i1 = substring1.indexOf("/");
            int i2 = substring1.indexOf("/", i1 + 1);
            if (i2 == -1) {
                i2 = substring1.length();
            }
            String sx = substring1.substring(i1, i2);
            count++;
            String key =count+"-";
            sbd.append(key);
            map.put(key, sx);
            substring1 = substring1.substring(i1+1);
        }

        return substring + sbd.toString();
    }



    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        StringBuilder sbd = new StringBuilder();
        int i = shortUrl.indexOf("//");
        String substring = shortUrl.substring(0, i + 2);
        String substring1 = shortUrl.substring(i + 2);
        int index;
        if((index=substring1.indexOf("/"))!=-1){
            sbd.append(substring1.substring(0,index));
        }else{
            return shortUrl;
        }
        String substring2 = substring1.substring(index+1);
        while (substring2.indexOf("-") != -1) {
            int i1 = substring2.indexOf("-");

            String sx = substring2.substring(0, i1+1);

            String str = map.get(sx);
            sbd.append(str);
            substring2 = substring2.substring(i1+1);
        }

        return substring+sbd.toString();
    }

    @Test
    public void t() {
        le535 le = new le535();
        System.out.println(le.encode(" https://leetcode.com/problems/design-tinyurl/"));
        System.out.println(le.decode(" https://leetcode.com/1-2-3-"));
    }
}
