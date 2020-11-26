package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le1370
 * @date 2020/11/25 0025上午 9:13
 * @description: TODO
 */
public class le1370 {
    StringBuffer buf = new StringBuffer();


    public String sortString(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap(10);
        char []ch =s.toCharArray();
        for(char c:ch){
            set.add(c);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        List<Character> list = new ArrayList(set);
        Collections.sort(list);
        //3.递归剩余字符

        while(map.size()>0){
            //1.先按字典序找所有字符 一次
            int i =0;
            for(;i<list.size();i++){
                //如果包含这个
                if(map.size()>0&&map.containsKey(list.get(i))){
                    buf.append(list.get(i));
                    if(map.get(list.get(i))-1==0){
                        map.remove(list.get(i));
                    }else {
                        map.put(list.get(i), map.get(list.get(i)) - 1);
                    }
                }
            }


            //2.按字典序倒叙找所有字符一次
            i--;
            for(;i>=0;--i){
                //如果包含这个
                if(map.size()>0&&map.containsKey(list.get(i))){
                    buf.append(list.get(i));
                    if(map.get(list.get(i))-1==0){
                        map.remove(list.get(i));
                    }else{
                        map.put(list.get(i),map.get(list.get(i))-1);
                    }
                }
            }
        }
        return buf.toString();
    }


    public String sortString2(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap(10);
        char []ch =s.toCharArray();
        for(char c:ch){
            set.add(c);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        List list = new ArrayList(set);
        Collections.sort(list);
        //3.递归剩余字符
        calc(list,map);
        return buf.toString();
    }

    private void calc(List<Character> list, Map<Character, Integer> map) {
        if(map.size()==0){
            return ;
        }
        //1.先按字典序找所有字符 一次
        for(int i=0;i<list.size();i++){
            //如果包含这个
            if(map.size()>0&&map.containsKey(list.get(i))){
                buf.append(list.get(i));
                if(map.get(list.get(i))-1==0){
                    map.remove(list.get(i));
                }else {
                    map.put(list.get(i), map.get(list.get(i)) - 1);
                }
            }
        }
        //2.按字典序倒叙找所有字符一次
        for(int i=list.size()-1;i>=0;i--){
            //如果包含这个
            if(map.size()>0&&map.containsKey(list.get(i))){
                buf.append(list.get(i));
                if(map.get(list.get(i))-1==0){
                    map.remove(list.get(i));
                }else{
                    map.put(list.get(i),map.get(list.get(i))-1);
                }

            }
        }
        calc(list,map);
    }

    @Test
    public void t(){
        sortString("aaaabbbbcccc");
    }
}
