package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le28
 * @date 2021-04-209:06
 * @description: TODO
 */
public class le28KMP {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    //计算next数组  即每个字符的
    public int[] kmp(String s) {
        char a[] = s.toCharArray();
        int local = 0;
        int local1 = -1;
        int next[] = new int[s.length()];
        next[0] = -1;
        while (local < s.length() - 1) {
            if (local1 == -1 || a[local1] == a[local]) {
                next[++local] = ++local1;
            } else {
                local1 = next[local1];
            }
        }
        return next;
    }


    public int indexof(String s, String parater) {
        char[] sc = s.toCharArray();
        char[] pc = parater.toCharArray();
        int next[] = kmp(parater);
        int slen = 0;
        int plen = 0;
        while (slen < s.length()&&plen<parater.length()) {
            //这个-1的处理 是对第一个就不匹配的处理  很灵性
            if (plen==-1||sc[slen]==pc[plen]){
                slen++;
                plen++;
            }else{
                plen = next[plen];
            }
        }

        if(plen==parater.length()){
            return slen-plen;
        }else{
            return -1;
        }

    }


    @Test
    public void test() {
       // kmp("1123456123");

        indexof("444144414444","17173");
    }


    @Test
    public void tes2t(){
        String s = "17173";

       int []num =  kmp2(s);

    }

    private int[] kmp2(String s) {
        char[] chars = s.toCharArray();
        int []num = new int[s.length()];
        int index =0;

        int back = -1;

        num[0] = back;

        while(index<num.length){

            if(back==-1||chars[index]==chars[back]){
                //前一个等于后一个   要加上
                num[++index] = ++back;
            }else{
                //但是  当不相等时  需要回溯
                back = num[back];

            }



        }

        return num;
    }
}
