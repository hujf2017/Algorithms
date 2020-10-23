package 比赛;

import java.util.Random;

/**
 * @author Hujf
 * @title: le5507
 * @date 2020/9/6 0006上午 10:31
 * @description: TODO
 */
public class le5507 {

    public static void main(String args[]){
        String s = "?";
        System.out.println(modifyString(s));
    }

    private static String modifyString(String s) {
        char sx[] = {'a','b','c','d','e','f','g','h','i','j','k',
                'l','m','n','o','p','q','r','s','t','u','v','w','x',
                'y','z'};
        char a[] = s.toCharArray();
        for(int i=1;i<s.length()-1;i++){
           if(a[i]=='?'){
               for(int j=0;j<sx.length;j++) {
                if(sx[j]!=a[i-1]&&sx[j]!=a[i+1]){
                    a[i] = sx[j];
                }
               }
           }
        }

        if(a[0]=='?'){
            if(a.length==1){
                return "a";
            }
            for(int j=0;j<sx.length;j++) {
                if(a[1]!=sx[j]){
                    a[0] = sx[j];
                }
            }
        }

        if(a[a.length-1]=='?'){
            for(int j=0;j<sx.length;j++) {
                if(a[a.length-2]!=sx[j]){
                    a[a.length-1] = sx[j];
                }
            }
        }
         s = String.valueOf(a);
        return s;
    }
}
