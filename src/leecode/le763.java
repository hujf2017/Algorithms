package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hujf
 * @title: le763
 * @date 2020/10/22 0022下午 4:23
 * @description: 合并划分字母区间
 */
public class le763 {
    Map<Character,Integer> mhave = new HashMap<Character,Integer>();
    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        int []list = new int[len+1];
        for(int i=0;i<len;i++){
            char a = S.charAt(i);
            if(mhave.containsKey(a)){
                int k = mhave.get(a);
                for(int j=k;j<=i;j++){
                    mhave.put(S.charAt(j),k);
                    list[j] = k;
                }
            }else{
                mhave.put(a,i+1);
                list[i] = i+1;
            }
        }
        int last = list[0];
        List<Integer>  aim = new ArrayList<Integer> ();
        int count = 1;
        for(int i=1;i<=len;i++){
            if(list[i]!=last){
                aim.add(count);
                count =1;
                last = list[i];
            }else{
                count++;
            }
        }
        return aim;
    }

    @Test
    public void t(){
        partitionLabels("ababcbacadefegdehijhklij");
        partitionLabels2("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels2(String S) {
        int[] last = new int[26];
        int length = S.length();

        //定义最后出现的位置
        for(int i=0;i<length;i++){
            last[S.charAt(i)-'a']=i;
        }

        List<Integer> partition = new ArrayList<Integer>();
        int start =0,end =0;
        for(int i = 0; i < length; i++){
            end =Math.max(end,last[S.charAt(i)-'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }

        }
        return partition;
    }
}
