package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le5662替换字母
 * @date 2021/1/24 0024上午 10:52
 * @description: TODO
 */
public class le5662替换字母 {
    public int minCharacters(String a, String b) {
        char []a1 = a.toCharArray();
        char []b1 = b.toCharArray();
        int []xA = new int[26];
        int []xB = new int[26];
        int MaxA = 0;
        int MinA = 27;
        int MaxB = 0;
        int MinB = 27;
        int max = 0;
        for(int i=0;i<a1.length;i++){
            int k = a1[i]-'a';
            xA[a1[i]-'a']+=1;
            MaxA = Math.max(a1[i]-'a',MaxA);
            MinA = Math.min(a1[i]-'a',MinA);
        }
        for(int i=0;i<b1.length;i++){
            xB[b1[i]-'a']+=1;
            MaxB = Math.max(b1[i]-'a',MaxB);
            MinB = Math.min(b1[i]-'a',MinB);
        }
        //找到修改全部相同的需要数据
        for(int i=0;i<26;i++){
            max = Math.max(max,xA[i]+xB[i]);
        }
        max = a.length()+b.length()-max;
        //找第一种 a<b  找到b的最小和a中比Bmin 大的数字  找到 a的最大和b中比a的最大小的
        int count1 =0;
        int count2 =0;
        for(int i=MinB;i<26;i++){
            count1+=xA[i];
        }

        for(int i=0;i<=MaxA;i++){
            count2+=xB[i];
        }
        int counta = Math.min(count1,count2);
        counta = Math.min(counta,max);

        //找第二种a>b   找到a的最小和b中比Bmin 大=的数字  找到 b的最大和a中比b的最大小=的
         count1 =0;
         count2 =0;
        for(int i=MinA;i<26;i++){
            count1+=xB[i];
        }

        for(int i=0;i<=MaxB;i++){
            count2+=xA[i];
        }
        int countb = Math.min(count1,count2);

        return Math.min(counta,countb);
    }


    @Test
    public void t(){
        minCharacters("ace","abe");
    }
}
