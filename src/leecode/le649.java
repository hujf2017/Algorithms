package leecode;

import java.util.*;

/**
 * @author Hujf
 * @title: le649
 * @date 2020/12/11 0011上午 9:32
 * @description: TODO
 */
public class le649 {
    Deque<Character> d = new ArrayDeque<>();
    Deque<Character> d2 = new ArrayDeque<>();
    public String predictPartyVictory(String senate) {
        char []a = senate.toCharArray();
        char first = a[0];
        int count = 0;
        boolean havedff =false;

        for(char c:a){
            if(c==first){
                count++;
            }else{
                if(count==0){
                    count++;
                    first = c;
                }else{
                    count--;
                }
            }

        }


//        char []a = senate.toCharArray();
//        char first = a[0];
//
//        for(char b: a){
//           if(b==first){
//               d.add(b) ;
//           }else{
//               //放到最后
//               d2.add(b);
//           }
//        }
//        while(!d.isEmpty()&&!d2.isEmpty()){
//          Iterator iterator= d.iterator();
//            while(iterator.hasNext()){
//                iterator.next();
//                d2.poll();
//                if(d2.size()==0){
//                    if(first=='R'){
//                        return "Radiant";
//                    }
//                    return "Dire";
//                }
//            }
//
//            Iterator iterator1= d2.iterator();
//            while(iterator1.hasNext()){
//                iterator1.next();
//                d.poll();
//                if(d.size()==0){
//                    if(first=='R'){
//                        return "Dire";
//                    }
//                    return "Radiant";
//                }
//            }
//        }
//        if(d.isEmpty()){
//            if(first=='R'){
//                return "Dire";
//            }
//            return "Radiant";
//        }else{
//            if(first=='R'){
//                return "Radiant";
//            }
//            return "Dire";
//        }
        return null;
    }
}
