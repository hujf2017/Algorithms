package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Hujf
 * @title: le804
 * @date 2020/11/2 0002下午 7:14
 * @description: TODO
 */
public class le804 {

    private String[] a = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        HashSet set = new HashSet();
        List<Character> asd = new ArrayList<>();
        char fires = 'a';
        for(int i=0;i<26;i++){
            asd.add((char) (fires+i));
        }

        for(String s :words){
            StringBuffer asds = new StringBuffer();
            for(int i =0;i<s.length();i++){
                char ss = s.charAt(i);
                int k=asd.indexOf(ss);
                asds.append(a[k]);
            }
            set.add(asds.toString());
        }

        return set.size();
    }

    @Test
    public void t(){
        uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
    }
}
