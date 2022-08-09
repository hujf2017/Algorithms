package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/8/5 16:57
 * @Description TODO
 */
public class le423 {
    public String originalDigits(String s) {
        int[] cc = new int[26];
        List<List<Integer>> a = new ArrayList<>(10);
        for(int i=0;i<10;i++){
            a.add(new ArrayList<>());
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int num = chars[i] - '0' - 49;
            cc[num] += 1;
        }
        //排除所有zero
        List ax = new ArrayList(cc[25]);
        for (int i = 0; i < cc[25]; i++) {
            cc[25]--;
            cc[4]--;
            cc[17]--;
            cc[14]--;
            ax.add(0);
        }
        a.remove(0);
        a.add(0,ax);


        List ax6 = new ArrayList();
        for (int i = 0; i < cc[23]; i++) {
            cc[8]--;
            cc[18]--;
            cc[23]--;
            ax.add(6);
        }
        a.remove(6);
        a.add(6,ax6);


        List ax8 = new ArrayList(cc[6]);
        //排除 eight
        for (int i = 0; i < cc[6]; i++) {
            cc[4]--;
            cc[6]--;
            cc[7]--;
            cc[8]--;
            cc[19]--;
            ax8.add(8);
        }
        a.remove(8);
        a.add(8,ax8);

        List ax2= new ArrayList();
        //排除 two
        for (int i = 0; i < cc[22]; i++) {
            cc[22]--;
            cc[14]--;
            cc[19]--;
            ax2.add(2);
        }
        a.remove(2);
        a.add(2,ax2);
        //排除 three
        List ax3= new ArrayList();
        for (int i = 0; i < cc[19]; i++) {
            cc[19]--;
            cc[4] = cc[4] - 2;
            cc[17]--;
            cc[7]--;
            ax3.add(3);
        }
        a.remove(3);
        a.add(3,ax3);
        //four
        List ax4= new ArrayList();
        for (int i = 0; i < cc[20]; i++) {
            cc[20]--;
            cc[5] --;
            cc[17]--;
            cc[14]--;
            ax4.add(4);
        }

        a.remove(4);
        a.add(4,ax4);
        //five
        List ax5= new ArrayList();
        for (int i = 0; i < cc[5]; i++) {
            cc[5]--;
            cc[21] --;
            cc[8]--;
            cc[4]--;
            ax5.add(5);
        }
        a.remove(5);
        a.add(5,ax5);
        //nine
        List ax9= new ArrayList();
        for (int i = 0; i < cc[8]; i++) {
            cc[8]--;
            cc[13] -=2;
            cc[4]--;
            ax9.add(9);
        }
        a.remove(9);
        a.add(9,ax9);
        //seven
        List ax7= new ArrayList();
        for (int i = 0; i < cc[21]; i++) {
            cc[18]--;
            cc[13] -=1;
            cc[4]-=2;
            cc[21]--;
            ax7.add(7);
        }
        a.remove(7);
        a.add(7,ax7);
        //one
        List ax1= new ArrayList();
        for (int i = 0; i < cc[4]; i++) {
            cc[13]--;
            cc[14] -=1;
            cc[4]-=1;
            ax1.add(1);
        }
        a.remove(1);
        a.add(1,ax1);
        StringBuilder stringBuilder = new StringBuilder();
        for(List<Integer> i:a){
           for(int ix:i){
               stringBuilder.append(ix);
           }
        }
        return stringBuilder.toString();
    }

    @Test
    public void t() {
        originalDigits("seven");
    }
}
