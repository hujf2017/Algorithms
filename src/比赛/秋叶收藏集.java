package 比赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: 秋叶收藏集
 * @date 2020/9/12 0012下午 3:57
 * @description: TODO
 */
public class 秋叶收藏集 {
    public static void main(String args[]) {
        String s = "yyrryyyryyr";
        System.out.println(minimumOperations(s));
    }

    public static int minimumOperations(String leaves) {
        int[] last = new int[4];
        int[] next = new int[4];
        int a = Integer.MAX_VALUE;
        int b =  (int) 1e8;
        System.out.println(a==b);


//        List<Integer> a = new ArrayList<>();
//        int count = 1;
//        int min = 1000000;
//        for (int i = 1; i < leaves.length(); i++) {
//
//            if (leaves.charAt(i) != leaves.charAt(i - 1)) {
//                a.add(count);
//                count = 1;
//            } else {
//                count++;
//            }
//        }
//        a.add(count);
//
//        if (a.size() == 1) {
//            if (leaves.charAt(0) == 'r') {
//                return 1;
//            } else {
//                return 2;
//            }
//        } else if (a.size() == 2) {
//            if (leaves.charAt(0) == 'r') {
//                if (a.get(0) == 1) {
//                    return 1;
//                } else {
//                    return 2;
//                }
//            } else {
//                if (a.get(0) == 1) {
//                    return 2;
//                } else {
//                    return 1;
//                }
//            }
//        }else if (a.size() == 3) {
//            if (leaves.charAt(0) == 'r') {
//                return 0;
//            } else {
//                if(a.get(0)==1||a.get(2)==1){
//                    if(a.get(0)==1&&a.get(2)==1){
//                        return 3;
//                    }else{
//                        return 2;
//                    }
//                }else{
//                    if(1+Math.min(a.get(0),a.get(2))>2+a.get(1)){
//                        return 2+a.get(1);
//                    }else{
//                        return 1+Math.min(a.get(0),a.get(2));
//                    }
//                }
//            }
//        }else {
//            for (int i = 1; i < a.size() - 1; i++) {
//                if (a.get(i) < min) {
//                    min = a.get(i);
//                }
//            }
//        }
        return  a;
    }
}
