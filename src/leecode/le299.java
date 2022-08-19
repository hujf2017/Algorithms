package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/10 14:07
 * @Description TODO
 */
public class le299 {

    public String getHint(String secret, String guess) {
        int []statics = new int[10];
        char[] chars = secret.toCharArray();
        for(char x:chars){
            statics[x-48]+=1;
        }

        char[] ch2 = guess.toCharArray();

        for(char x:ch2){
            statics[x-48]-=1;
        }

        int numC =0;
        for(int i:statics){
            if(i>0){
                numC+=i;
            }
        }

        int numA=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==ch2[i]){
                numA++;
            }
        }
        int numB = chars.length-numA-numC;
        return numA+"A"+numB+"B";
    }

    @Test
    public void t(){
        System.out.println(getHint("1123", "0111"));
    }
}
